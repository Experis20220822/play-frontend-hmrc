/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.warningtext

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.html.components._

case class WarningText(
  iconFallbackText: String = "",
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object WarningText {

  def defaultObject: WarningText = WarningText()

  implicit def jsonReads: Reads[WarningText] =
    (
      (__ \ "iconFallbackText").readWithDefault[String](defaultObject.iconFallbackText) and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(WarningText.apply _)

  implicit def jsonWrites: OWrites[WarningText] =
    (
      (__ \ "iconFallbackText").write[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(WarningText.unapply))

}
