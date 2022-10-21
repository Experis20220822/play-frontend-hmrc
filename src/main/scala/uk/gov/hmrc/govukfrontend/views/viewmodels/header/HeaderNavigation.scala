/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.header

import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty, Text}
import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Content.writesContent

final case class HeaderNavigation(
  @deprecated("Use content", "Since play-frontend-govuk v0.48.0") text: Option[String] = None,
  href: Option[String] = None,
  active: Boolean = false,
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object HeaderNavigation {

  def defaultObject: HeaderNavigation = HeaderNavigation()

  implicit def jsonReads: Reads[HeaderNavigation] =
    (
      Reads.pure(None) and
        (__ \ "href").readNullable[String] and
        (__ \ "active").readWithDefault[Boolean](defaultObject.active) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(HeaderNavigation.apply _)

  implicit def jsonWrites: OWrites[HeaderNavigation] = OWrites { hn =>
    val content = hn.content match {
      case Empty => hn.text.map(Text).getOrElse(Empty)
      case _     => hn.content
    }
    Json.obj(
      "href"       -> hn.href,
      "active"     -> hn.active,
      "attributes" -> hn.attributes
    ) ++ writesContent().writes(content)
  }
}
