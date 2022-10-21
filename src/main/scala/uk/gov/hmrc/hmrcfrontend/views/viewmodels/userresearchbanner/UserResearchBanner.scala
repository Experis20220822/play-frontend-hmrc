/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.userresearchbanner

import play.api.libs.json.{Json, OFormat}
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{En, Language}

case class UserResearchBanner(
  language: Language = En,
  url: String = ""
)

object UserResearchBanner {
  implicit def jsonFormats: OFormat[UserResearchBanner] = Json.using[Json.WithDefaultValues].format[UserResearchBanner]
}
