/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views

import play.twirl.api.Html
import uk.gov.hmrc.govukfrontend.views.html.components.implicits.{RichHtml => GovukRichHtml, RichOptionString => GovukRichOptionString, RichString => GovukRichString}
import uk.gov.hmrc.hmrcfrontend.views.implicits.{RichAccountMenuSupport, RichCharacterCountSupport, RichDateInputSupport, RichErrorSummarySupport}

trait Implicits
    extends RichCharacterCountSupport
    with RichErrorSummarySupport
    with RichDateInputSupport
    with RichAccountMenuSupport {

  implicit class RichHtml(html: Html) extends GovukRichHtml(html)

  implicit class RichString(s: String) extends GovukRichString(s)

  implicit class RichOptionString(optString: Option[String]) extends GovukRichOptionString(optString)
}

object Implicits extends Implicits
