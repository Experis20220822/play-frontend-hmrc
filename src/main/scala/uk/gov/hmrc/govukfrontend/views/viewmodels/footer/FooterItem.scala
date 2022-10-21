/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.footer

import play.api.libs.functional.syntax._
import play.api.libs.json._

final case class FooterItem(
  text: Option[String] = None,
  href: Option[String] = None,
  attributes: Map[String, String] = Map.empty
)

object FooterItem {

  def defaultObject: FooterItem = FooterItem()

  implicit def jsonReads: Reads[FooterItem] =
    (
      (__ \ "text").readNullable[String] and
        (__ \ "href").readNullable[String] and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(FooterItem.apply _)

  implicit def jsonWrites: OWrites[FooterItem] =
    (
      (__ \ "text").writeNullable[String] and
        (__ \ "href").writeNullable[String] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(FooterItem.unapply))

}
