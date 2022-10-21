/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.timeline

import uk.gov.hmrc.hmrcfrontend.views.viewmodels.timeline.Event
import play.api.libs.json.{Json, OFormat}

case class Timeline(
  headingLevel: Int = 2,
  events: Seq[Event] = Seq.empty
)

object Timeline {
  implicit def jsonFormats: OFormat[Timeline] = Json.using[Json.WithDefaultValues].format[Timeline]
}
