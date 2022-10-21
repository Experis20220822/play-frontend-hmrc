/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.implicits

import play.api.i18n.Messages
import play.api.mvc.RequestHeader
import uk.gov.hmrc.hmrcfrontend.config.AccountMenuConfig
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu.{AccountMenu, BusinessTaxAccount}
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{Cy, En}

trait RichAccountMenuSupport extends {

  implicit class RichAccountMenu(accountMenu: AccountMenu)(implicit accountMenuConfig: AccountMenuConfig) {

    def withUrlsFromConfig()(implicit messages: Messages, request: RequestHeader): AccountMenu = {

      def updateDefault(originalHref: String, hrefFromConfig: String): String =
        if (originalHref == "#") hrefFromConfig else originalHref

      accountMenu.copy(
        accountHome = accountMenu.accountHome.copy(
          href = updateDefault(accountMenu.accountHome.href, accountMenuConfig.accountHomeHref)
        ),
        messages = accountMenu.messages.copy(
          href = updateDefault(accountMenu.messages.href, accountMenuConfig.messagesHref)
        ),
        checkProgress = accountMenu.checkProgress.copy(
          href = updateDefault(accountMenu.checkProgress.href, accountMenuConfig.checkProgressHref)
        ),
        yourProfile = accountMenu.yourProfile.copy(
          href = updateDefault(accountMenu.yourProfile.href, accountMenuConfig.yourProfileHref)
        ),
        businessTaxAccount = accountMenu.businessTaxAccount.map(businessAccount =>
          businessAccount.copy(href = updateDefault(businessAccount.href, accountMenuConfig.businessTaxAccountHref))
        ),
        language = if (messages.lang.code == "cy") Cy else En
      )
    }

    def withMessagesCount(count: Int): AccountMenu = accountMenu.copy(
      messages = accountMenu.messages.copy(messageCount = Some(count))
    )
  }

}
