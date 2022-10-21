/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.header

import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty, Text}
import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Content.writesContent

final case class NavigationItem(
  content: Content = Empty,
  href: Option[String] = None,
  active: Boolean = false,
  attributes: Map[String, String] = Map.empty
)

object NavigationItem {

  def defaultObject: NavigationItem = NavigationItem(Empty)

  implicit def jsonReads: Reads[NavigationItem] =
    (
      (Content.reads or Reads.pure(defaultObject.content)) and
        (__ \ "href").readNullable[String] and
        (__ \ "active").readWithDefault[Boolean](defaultObject.active) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(NavigationItem.apply _)

  implicit def jsonWrites: OWrites[NavigationItem] = OWrites { hn =>
    Json.obj(
      "href"       -> hn.href,
      "active"     -> hn.active,
      "attributes" -> hn.attributes
    ) ++ writesContent().writes(hn.content)
  }
}
