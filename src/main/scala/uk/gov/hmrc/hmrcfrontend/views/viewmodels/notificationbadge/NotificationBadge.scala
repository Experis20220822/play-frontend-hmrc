/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.notificationbadge

import play.api.libs.json._

case class NotificationBadge(
  text: String = ""
)

object NotificationBadge {

  def apply(text: Int): NotificationBadge = new NotificationBadge(text.toString)

  implicit def jsonReads: Reads[NotificationBadge] = new Reads[NotificationBadge] {
    override def reads(json: JsValue): JsResult[NotificationBadge] =
      (json \ "text").asOpt[String] orElse (json \ "text").asOpt[Int].map(_.toString) match {
        case Some(text) => JsSuccess(NotificationBadge(text))
        case None       => JsError("Cannot parse value text as either String or Int")
      }
  }

  implicit def jsonWrites: OWrites[NotificationBadge] = Json.writes[NotificationBadge]
}
