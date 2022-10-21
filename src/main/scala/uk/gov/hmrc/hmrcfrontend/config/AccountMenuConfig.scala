/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.config

import play.api.Configuration
import javax.inject.Inject

class AccountMenuConfig @Inject() (configuration: Configuration) {
  val accountHomeHref: String        = configuration.get[String]("pta-account-menu.account-home.href")
  val messagesHref: String           = configuration.get[String]("pta-account-menu.messages.href")
  val checkProgressHref: String      = configuration.get[String]("pta-account-menu.check-progress.href")
  val yourProfileHref: String        = configuration.get[String]("pta-account-menu.your-profile.href")
  val businessTaxAccountHref: String = configuration.get[String]("pta-account-menu.business-tax-account.href")
}
