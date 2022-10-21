/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import play.api.libs.json._
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{En, Language}

case class AccountMenu(
  accountHome: AccountHome = AccountHome(),
  messages: AccountMessages = AccountMessages(),
  checkProgress: CheckProgress = CheckProgress(),
  yourProfile: YourProfile = YourProfile(),
  businessTaxAccount: Option[BusinessTaxAccount] = None,
  signOut: SignOut = SignOut(),
  language: Language = En
)

object AccountMenu {

  implicit def jsonFormats: OFormat[AccountMenu] = Json.using[Json.WithDefaultValues].format[AccountMenu]
}
