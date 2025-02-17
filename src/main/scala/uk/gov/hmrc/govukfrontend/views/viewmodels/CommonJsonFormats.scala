/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels

import play.api.libs.json._
import play.twirl.api.Html

import scala.util.Try

object CommonJsonFormats {
  val readsFormGroupClasses: Reads[String] =
    (__ \ "formGroup" \ "classes").read[String].orElse(Reads.pure(""))

  val writesFormGroupClasses: OWrites[String] = new OWrites[String] {
    override def writes(classes: String): JsObject =
      Json.obj("formGroup" -> Json.obj("classes" -> classes))
  }

  val readsCountMessageClasses: Reads[String] =
    (__ \ "countMessage" \ "classes").read[String].orElse(Reads.pure(""))

  val writesCountMessageClasses: OWrites[String] = new OWrites[String] {
    override def writes(classes: String): JsObject =
      Json.obj("countMessage" -> Json.obj("classes" -> classes))
  }

  implicit val htmlWrites: Writes[Html] = new Writes[Html] {
    def writes(o: Html): JsString = JsString(o.body)
  }

  implicit val htmlReads: Reads[Html] = new Reads[Html] {
    def reads(json: JsValue): JsResult[Html] = json match {
      case JsString(s) => JsSuccess(Html(s))
      case _           => JsError("error.expected.jsstring")
    }
  }

  val readsConditionalHtml: Reads[Option[Html]] =
    (__ \ "conditional" \ "html").readNullable[String].map(_.map(Html(_))).orElse(Reads.pure(None))

  val writesConditionalHtml: OWrites[Option[Html]] = new OWrites[Option[Html]] {
    override def writes(o: Option[Html]): JsObject =
      o.map(o => Json.obj("conditional" -> Json.obj("html" -> o.body))).getOrElse(Json.obj())
  }

  val attributesReads: Reads[Map[String, String]] = new Reads[Map[String, String]] {
    override def reads(json: JsValue): JsResult[Map[String, String]] = {
      val keyValueTuples = json.as[JsObject].keys.map { key =>
        asOptString((json \ key).as[JsValue])
          .map(stringValue => (key, stringValue))
      }
      JsSuccess(keyValueTuples.flatten.toMap)
    }
  }

  val forgivingOptStringReads: Reads[Option[String]] = new Reads[Option[String]] {
    override def reads(json: JsValue): JsResult[Option[String]] =
      JsSuccess(asOptString(json))
  }

  val forgivingStringReads: Reads[String] = new Reads[String] {
    override def reads(json: JsValue): JsResult[String] =
      asOptString(json) match {
        case Some(validString) => JsSuccess(validString)
        case _                 => JsError("error.expected.jsstring")
      }
  }

  private def asOptString(json: JsValue): Option[String] =
    json.asOpt[String].orElse {
      json.asOpt[Int].map(_.toString).orElse {
        json.asOpt[Boolean].map(_.toString)
      }
    }

  def forgivingSeqReads[T](implicit readsT: Reads[T]): Reads[Seq[T]] = new Reads[Seq[T]] {
    override def reads(json: JsValue): JsResult[Seq[T]] =
      // JsRequest uses scala.collection.Seq, where as default Seq for Scala 2.13 is scala.collection.immutable.Seq
      json.validate[scala.collection.Seq[JsValue]].map { jsValues =>
        forgivingSeqValidates(jsValues)(readsT)
      }
  }

  private def forgivingSeqValidates[T](jsValues: scala.collection.Seq[JsValue])(implicit readsT: Reads[T]): Seq[T] =
    jsValues.toSeq.flatMap { jsValue =>
      val maybeValidated: Option[JsResult[T]] =
        Try(jsValue.validate[T](readsT)).toOption
      maybeValidated.flatMap(_.asOpt)
    }
}
