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

package uk.gov.hmrc.helpers.views

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import play.twirl.api.Html

trait JsoupHelpers {

  implicit class RichHtml(html: Html) {
    def select(cssQuery: String): Elements =
      parseNoPrettyPrinting(html).select(cssQuery)
  }

  // otherwise Jsoup inserts linefeed https://stackoverflow.com/questions/12503117/jsoup-line-feed
  def parseNoPrettyPrinting(html: Html): Document = {
    val doc = Jsoup.parse(html.body)
    doc.outputSettings().prettyPrint(false)
    doc
  }
}
