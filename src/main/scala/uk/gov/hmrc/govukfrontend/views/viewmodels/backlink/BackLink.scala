/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package backlink

import play.api.i18n.Messages
import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty, Text}

case class BackLink(
  href: String = "",
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object BackLink {

  def defaultObject: BackLink = BackLink()

  def mimicsBrowserBackButtonViaJavaScript(implicit messages: Messages): BackLink = BackLink(
    href = "#",
    attributes = Map("data-module" -> "hmrc-back-link"),
    content = Text(messages("back.text"))
  )

  implicit def jsonReads: Reads[BackLink] =
    (
      (__ \ "href").readWithDefault[String](defaultObject.href) and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(BackLink.apply _)

  implicit def jsonWrites: OWrites[BackLink] =
    (
      (__ \ "href").write[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(BackLink.unapply))
}
