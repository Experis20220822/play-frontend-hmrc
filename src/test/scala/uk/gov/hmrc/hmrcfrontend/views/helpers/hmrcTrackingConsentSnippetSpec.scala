/*
 * Copyright 2020 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcfrontend.views.helpers

import org.scalatest.{Matchers, WordSpec}
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder
import uk.gov.hmrc.hmrcfrontend.views.JsoupHelpers
import uk.gov.hmrc.hmrcfrontend.views.html.helpers.HmrcTrackingConsentSnippet

class TrackingConsentSnippetSpec extends WordSpec with Matchers with GuiceOneAppPerSuite with JsoupHelpers {
  override def fakeApplication(): Application =
    new GuiceApplicationBuilder()
      .configure(Map(
        "play.allowGlobalApplication"             -> "true",
        "optimizely.url"                          -> "https://cdn.optimizely.com/",
        "optimizely.projectId"                    -> "1234567",
        "tracking-consent-frontend.gtm.container" -> "d"
      ))
      .build()

  "TrackingConsentSnippet" should {

    "include the tracking consent script tag" in {
      val content = HmrcTrackingConsentSnippet(None)
      val scripts = content.select("script#tracking-consent-script-tag")
      scripts should have size 1
    }

    "include the tracking consent script tag with the correct container attribute" in {
      val content = HmrcTrackingConsentSnippet(None)
      val scripts = content.select("script#tracking-consent-script-tag")
      scripts.first.attr("data-gtm-container") should be("d")
    }

    "include the tracking script first" in {
      val content = HmrcTrackingConsentSnippet(None)
      val scripts = content.select("script")

      scripts.get(0).attr("id")  should be("tracking-consent-script-tag")
      scripts.get(0).attr("src") should be("http://localhost:12345/tracking-consent/tracking.js")
    }

    "include the optimizely script tag" in {
      val content = HmrcTrackingConsentSnippet(None)
      val scripts = content.select("script")

      scripts.get(1).attr("src") should be("https://cdn.optimizely.com/1234567.js")
    }

    "include the optimizely gtm script tag" in {
      val content = HmrcTrackingConsentSnippet(None)
      val scripts = content.select("script")

      scripts.get(2).attr("src") should be("http://localhost:12345/tracking-consent/tracking/optimizely.js")
    }

    "include nonce attribute for all scripts" in {
      val scripts = HmrcTrackingConsentSnippet(Some("abcdefghij")).select("script")

      scripts.get(0).attr("nonce") should be("abcdefghij")
      scripts.get(1).attr("nonce") should be("abcdefghij")
      scripts.get(2).attr("nonce") should be("abcdefghij")
    }

    "not include script tags with any nonce attributes if nonce is not defined" in {
      val scripts = HmrcTrackingConsentSnippet(None).select("script")
      scripts.get(0).attr("nonce") should be("")
      scripts.get(1).attr("nonce") should be("")
      scripts.get(2).attr("nonce") should be("")
    }
  }
}
