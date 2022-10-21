/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class SignOut(
  href: String = "#"
)

object SignOut {

  implicit def jsonFormats: OFormat[SignOut] = Json.using[Json.WithDefaultValues].format[SignOut]
}
