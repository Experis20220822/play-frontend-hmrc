/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class CheckProgress(
  href: String = "#",
  active: Boolean = false
)

object CheckProgress {

  implicit def jsonFormats: OFormat[CheckProgress] = Json.using[Json.WithDefaultValues].format[CheckProgress]
}
