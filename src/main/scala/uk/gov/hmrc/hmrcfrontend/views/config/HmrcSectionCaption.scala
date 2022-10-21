/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.config

import play.api.i18n.Messages
import play.twirl.api.HtmlFormat
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, HtmlContent}

object HmrcSectionCaption {
  def apply(
    section: Content
  )(implicit messages: Messages): Content = {
    require(section.nonEmpty, "HmrcSectionCaption section must not be empty")
    HtmlContent(
      s"""<span class="govuk-visually-hidden">${HtmlFormat.escape(
        messages("this.section.is")
      )} </span>${section.asHtml}"""
    )
  }
}
