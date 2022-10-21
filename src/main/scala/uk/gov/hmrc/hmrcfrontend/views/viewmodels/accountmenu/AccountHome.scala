/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class AccountHome(
  href: String = "#",
  active: Boolean = false
)

object AccountHome {

  implicit def jsonFormats: OFormat[AccountHome] = Json.using[Json.WithDefaultValues].format[AccountHome]
}
