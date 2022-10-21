/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class PersonalDetails(
  href: String = "#"
)

object PersonalDetails {

  implicit def jsonFormats: OFormat[PersonalDetails] = Json.using[Json.WithDefaultValues].format[PersonalDetails]
}
