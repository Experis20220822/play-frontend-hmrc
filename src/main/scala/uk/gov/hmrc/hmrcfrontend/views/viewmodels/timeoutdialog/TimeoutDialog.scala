/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.timeoutdialog

import play.api.libs.json._

case class TimeoutDialog(
  language: Option[String] = None,
  timeout: Option[Int] = None,
  countdown: Option[Int] = None,
  keepAliveUrl: Option[String] = None,
  signOutUrl: Option[String] = None,
  timeoutUrl: Option[String] = None,
  title: Option[String] = None,
  message: Option[String] = None,
  messageSuffix: Option[String] = None,
  keepAliveButtonText: Option[String] = None,
  signOutButtonText: Option[String] = None,
  synchroniseTabs: Boolean = false
)

object TimeoutDialog {

  implicit def jsonFormats: OFormat[TimeoutDialog] = Json.using[Json.WithDefaultValues].format[TimeoutDialog]
}
