/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.skiplink

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.html.components._

case class SkipLink(
  href: String = "",
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object SkipLink {

  def defaultObject: SkipLink = SkipLink()

  implicit def jsonReads: Reads[SkipLink] =
    (
      (__ \ "href").readWithDefault[String](defaultObject.href) and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(SkipLink.apply _)

  implicit def jsonWrites: OWrites[SkipLink] =
    (
      (__ \ "href").write[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(SkipLink.unapply))

}
