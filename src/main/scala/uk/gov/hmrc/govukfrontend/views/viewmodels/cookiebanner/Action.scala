/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.cookiebanner

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class Action(
  text: String = "",
  inputType: Option[String] = None,
  href: Option[String] = None,
  name: Option[String] = None,
  value: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object Action {
  def defaultObject: Action = Action()

  implicit def jsonReads: Reads[Action] = (
    (__ \ "text").read[String] and
      (__ \ "type").readNullable[String] and
      (__ \ "href").readNullable[String] and
      (__ \ "name").readNullable[String] and
      (__ \ "value").readNullable[String] and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads)
  )(Action.apply _)

  implicit def jsonWrites: OWrites[Action] =
    (
      (__ \ "text").write[String] and
        (__ \ "type").writeNullable[String] and
        (__ \ "href").writeNullable[String] and
        (__ \ "name").writeNullable[String] and
        (__ \ "value").writeNullable[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(Action.unapply))
}
