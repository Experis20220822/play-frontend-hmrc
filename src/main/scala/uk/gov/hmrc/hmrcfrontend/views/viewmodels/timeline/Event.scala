/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.timeline

import play.api.libs.json.{Json, OFormat}

case class Event(
  title: String,
  time: String,
  content: String,
  datetime: Option[String] = None
)

object Event {
  implicit def jsonFormats: OFormat[Event] = Json.using[Json.WithDefaultValues].format[Event]
}
