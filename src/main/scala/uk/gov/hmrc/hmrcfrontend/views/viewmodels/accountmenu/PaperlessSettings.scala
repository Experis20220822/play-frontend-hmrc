/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class PaperlessSettings(
  href: String = "#"
)

object PaperlessSettings {

  implicit def jsonFormats: OFormat[PaperlessSettings] = Json.using[Json.WithDefaultValues].format[PaperlessSettings]
}
