/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.reporttechnicalissue

import play.api.libs.json._
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{En, Language}

case class ReportTechnicalIssue(
  serviceId: String = "",
  serviceCode: String = "",
  language: Language = En,
  classes: Option[String] = None,
  referrerUrl: Option[String] = None,
  baseUrl: Option[String] = None
)

object ReportTechnicalIssue {

  implicit def jsonFormats: OFormat[ReportTechnicalIssue] =
    Json.using[Json.WithDefaultValues].format[ReportTechnicalIssue]
}
