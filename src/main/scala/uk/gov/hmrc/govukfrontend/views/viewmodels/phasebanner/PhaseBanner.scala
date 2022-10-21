/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.phasebanner

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.html.components._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class PhaseBanner(
  tag: Option[Tag] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object PhaseBanner {

  def defaultObject: PhaseBanner = PhaseBanner()

  implicit def jsonReads: Reads[PhaseBanner] =
    (
      (__ \ "tag").readNullable[Tag] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads) and
        Content.reads
    )(PhaseBanner.apply _)

  implicit def jsonWrites: OWrites[PhaseBanner] =
    (
      (__ \ "tag").writeNullable[Tag] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(PhaseBanner.unapply))

}
