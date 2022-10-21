/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.insettext

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

case class InsetText(
  id: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object InsetText {

  def defaultObject: InsetText = InsetText()

  implicit def jsonReads: Reads[InsetText] =
    (
      (__ \ "id").readNullable[String] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(InsetText.apply _)

  implicit def jsonWrites: OWrites[InsetText] =
    (
      (__ \ "id").writeNullable[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(InsetText.unapply))

}
