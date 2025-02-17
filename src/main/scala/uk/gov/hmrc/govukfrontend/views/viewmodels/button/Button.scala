/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.button

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.html.components._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class Button(
  element: Option[String] = None,
  name: Option[String] = None,
  inputType: Option[String] = None,
  value: Option[String] = None,
  disabled: Boolean = false,
  href: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  preventDoubleClick: Boolean = false,
  isStartButton: Boolean = false,
  content: Content = Empty
)

object Button {

  def defaultObject: Button = Button()

  implicit def jsonReads: Reads[Button] =
    (
      (__ \ "element").readNullable[String] and
        (__ \ "name").readNullable[String] and
        (__ \ "type").readNullable[String] and
        (__ \ "value").readNullable[String] and
        (__ \ "disabled").readWithDefault[Boolean](defaultObject.disabled) and
        (__ \ "href").readNullable[String] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads) and
        (__ \ "preventDoubleClick").readWithDefault[Boolean](defaultObject.preventDoubleClick) and
        (__ \ "isStartButton").readWithDefault[Boolean](defaultObject.isStartButton) and
        Content.reads
    )(Button.apply _)

  implicit def jsonWrites: OWrites[Button] =
    (
      (__ \ "element").writeNullable[String] and
        (__ \ "name").writeNullable[String] and
        (__ \ "type").writeNullable[String] and
        (__ \ "value").writeNullable[String] and
        (__ \ "disabled").write[Boolean] and
        (__ \ "href").writeNullable[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        (__ \ "preventDoubleClick").write[Boolean] and
        (__ \ "isStartButton").write[Boolean] and
        Content.writes
    )(unlift(Button.unapply))

}
