/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accountmenu

import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Arbitrary._
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.Generators._
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.Generators.arbLanguage

object Generators {

  implicit val arbAccountHome: Arbitrary[AccountHome] = Arbitrary {
    for {
      href   <- genAlphaStr()
      active <- arbBool.arbitrary
    } yield AccountHome(href = href, active = active)
  }

  implicit val arbCheckProgress: Arbitrary[CheckProgress] = Arbitrary {
    for {
      href   <- genAlphaStr()
      active <- arbBool.arbitrary
    } yield CheckProgress(href = href, active = active)
  }

  implicit val arbMessages: Arbitrary[AccountMessages] = Arbitrary {
    for {
      href         <- genAlphaStr()
      active       <- arbBool.arbitrary
      messageCount <- Gen.option(Gen.chooseNum(0, 5))
    } yield AccountMessages(href = href, active = active, messageCount = messageCount)
  }

  implicit val arbBusinessTaxAccount: Arbitrary[BusinessTaxAccount] = Arbitrary {
    for {
      href   <- genAlphaStr()
      active <- arbBool.arbitrary
    } yield BusinessTaxAccount(href = href, active = active)
  }

  implicit val arbYourProfile: Arbitrary[YourProfile] = Arbitrary {
    for {
      href <- genAlphaStr()
    } yield YourProfile(href = href)
  }

  implicit val arbSignOut: Arbitrary[SignOut] = Arbitrary {
    for {
      href <- genAlphaStr()
    } yield SignOut(href = href)
  }

  implicit val arbAccountMenu: Arbitrary[AccountMenu] = Arbitrary {
    for {
      accountHome        <- arbAccountHome.arbitrary
      messages           <- arbMessages.arbitrary
      checkProgress      <- arbCheckProgress.arbitrary
      yourProfile        <- arbYourProfile.arbitrary
      signOut            <- arbSignOut.arbitrary
      businessTaxAccount <- Gen.option(arbBusinessTaxAccount.arbitrary)
      language           <- arbLanguage.arbitrary
    } yield AccountMenu(
      accountHome = accountHome,
      messages = messages,
      checkProgress = checkProgress,
      yourProfile = yourProfile,
      businessTaxAccount = businessTaxAccount,
      signOut = signOut,
      language = language
    )
  }
}
