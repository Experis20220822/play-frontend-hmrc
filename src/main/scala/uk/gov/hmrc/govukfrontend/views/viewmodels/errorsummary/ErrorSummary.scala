/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.errorsummary

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

case class ErrorSummary(
  errorList: Seq[ErrorLink] = Nil,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  title: Content = Empty,
  description: Content = Empty,
  disableAutoFocus: Boolean = false
)

object ErrorSummary {

  def defaultObject: ErrorSummary = ErrorSummary()

  implicit def jsonReads: Reads[ErrorSummary] =
    (
      (__ \ "errorList").readWithDefault[Seq[ErrorLink]](defaultObject.errorList) and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.readsHtmlOrText((__ \ "titleHtml"), (__ \ "titleText")) and
        Content.readsHtmlOrText((__ \ "descriptionHtml"), (__ \ "descriptionText")) and
        (__ \ "disableAutoFocus").readWithDefault[Boolean](defaultObject.disableAutoFocus)
    )(ErrorSummary.apply _)

  implicit def jsonWrites: OWrites[ErrorSummary] =
    (
      (__ \ "errorList").write[Seq[ErrorLink]] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writesContent("titleHtml", "titleText") and
        Content.writesContent("descriptionHtml", "descriptionText") and
        (__ \ "disableAutoFocus").write[Boolean]
    )(unlift(ErrorSummary.unapply))

}
