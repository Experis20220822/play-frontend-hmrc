/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class YourProfile(
  href: String = "#",
  active: Boolean = false
)

object YourProfile {
  implicit def jsonFormats: OFormat[YourProfile] = Json.using[Json.WithDefaultValues].format[YourProfile]
}
