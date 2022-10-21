/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package breadcrumbs

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class BreadcrumbsItem(
  content: Content = Empty,
  href: Option[String] = None,
  attributes: Map[String, String] = Map.empty
)

object BreadcrumbsItem {

  def defaultObject: BreadcrumbsItem = BreadcrumbsItem()

  implicit def jsonReads: Reads[BreadcrumbsItem] = (
    Content.reads and
      (__ \ "href").readNullable[String] and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
  )(BreadcrumbsItem.apply _)

  implicit def jsonWrites: OWrites[BreadcrumbsItem] = (
    Content.writes and
      (__ \ "href").writeNullable[String] and
      (__ \ "attributes").write[Map[String, String]]
  )(unlift(BreadcrumbsItem.unapply))
}
