/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.supportfrontend.views

import play.api.libs.json._

import scala.util.Try

case class IntString(int: Int) extends AnyVal {
  def str: String = int.toString
}

object IntString {

  def apply(intStr: String): Try[IntString] = Try(intStr.toInt).map(IntString(_))

  implicit object IntStringFormat extends Format[IntString] {
    def reads(json: JsValue): JsResult[IntString] = json match {
      case JsNumber(n) if n.isValidInt => JsSuccess(IntString(n.toInt))
      case JsNumber(_)                 => JsError("error.expected.validinteger")
      case JsString(s)                 => IntString(s).map(JsSuccess(_)).getOrElse(JsError("error.expected.integerstring"))
      case _                           => JsError("error.expected.integerjsstringorjsnumber")
    }

    def writes(o: IntString): JsString = JsString(o.str)
  }

  implicit class IntStringReads(intStringReads: Reads[IntString]) {
    def int: Reads[Int]    = intStringReads.map(_.int)
    def str: Reads[String] = intStringReads.map(_.str)
  }

  implicit class IntStringNullableReads(intStringNullableReads: Reads[Option[IntString]]) {
    def int: Reads[Option[Int]]    = intStringNullableReads.map(_.map(_.int))
    def str: Reads[Option[String]] = intStringNullableReads.map(_.map(_.str))
  }

}
