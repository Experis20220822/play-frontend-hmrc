/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.cookiebanner

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Content.readsHtmlOrText
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

case class Message(
  heading: Content = Empty,
  content: Content = Empty,
  // FIXME: wrapping in Option is a consequence of govuk-frontend having different behaviour
  // for undefined/null and an empty list
  actions: Option[Seq[Action]] = None,
  hidden: Boolean = false,
  role: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object Message {
  def defaultObject: Message = Message()

  implicit def jsonReads: Reads[Message] = (
    readsHtmlOrText(__ \ "headingHtml", __ \ "headingText") and
      Content.reads and
      (__ \ "actions").readNullable[Seq[Action]] and
      (__ \ "hidden").readWithDefault[Boolean](defaultObject.hidden) and
      (__ \ "role").readNullable[String] and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads)
  )(Message.apply _)

  implicit def jsonWrites: OWrites[Message] = (
    Content.writesContent("headingHtml", "headingText") and
      Content.writesContent() and
      (__ \ "actions").writeNullable[Seq[Action]] and
      (__ \ "hidden").write[Boolean] and
      (__ \ "role").writeNullable[String] and
      (__ \ "classes").write[String] and
      (__ \ "attributes").write[Map[String, String]]
  )(unlift(Message.unapply))
}
