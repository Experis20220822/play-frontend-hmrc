/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._

case class BusinessTaxAccount(
  href: String = "#",
  active: Boolean = false
)

object BusinessTaxAccount {
  implicit def jsonFormats: OFormat[BusinessTaxAccount] = Json.using[Json.WithDefaultValues].format[BusinessTaxAccount]
}
