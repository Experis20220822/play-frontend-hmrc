/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class AccountMessages(
  href: String = "#",
  active: Boolean = false,
  messageCount: Option[Int] = None
)

object AccountMessages {

  implicit def jsonFormats: OFormat[AccountMessages] = Json.using[Json.WithDefaultValues].format[AccountMessages]
}
