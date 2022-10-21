/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package label

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Label(
  forAttr: Option[String] = None,
  isPageHeading: Boolean = false,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object Label {

  def defaultObject: Label = Label()

  implicit def jsonReads: Reads[Label] =
    (
      (__ \ "for").readNullable[String] and
        (__ \ "isPageHeading").readWithDefault[Boolean](defaultObject.isPageHeading) and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(Label.apply _)

  implicit def jsonWrites: OWrites[Label] =
    (
      (__ \ "for").writeNullable[String] and
        (__ \ "isPageHeading").write[Boolean] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(Label.unapply))

}
