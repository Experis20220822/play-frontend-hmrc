/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.accordion

import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._
import play.api.libs.functional.syntax._

case class Accordion(
  id: String = "",
  headingLevel: Int = 2,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  items: Seq[Section] = Nil
)

object Accordion {

  def defaultObject: Accordion = Accordion()

  implicit def jsonReads: Reads[Accordion] = (
    (__ \ "id").readWithDefault[String](defaultObject.id) and
      (__ \ "headingLevel").readWithDefault[Int](defaultObject.headingLevel) and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads) and
      (__ \ "items").readWithDefault[Seq[Section]](defaultObject.items)(forgivingSeqReads[Section])
  )(Accordion.apply _)

  implicit def jsonWrites: OWrites[Accordion] = Json.writes[Accordion]
}
