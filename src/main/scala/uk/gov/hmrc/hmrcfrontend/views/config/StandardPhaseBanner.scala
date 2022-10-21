/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.config

import play.api.i18n.Messages
import play.api.mvc.RequestHeader
import play.twirl.api.HtmlFormat
import uk.gov.hmrc.govukfrontend.views.Aliases.{HtmlContent, PhaseBanner, Tag, Text}
import uk.gov.hmrc.hmrcfrontend.config.ContactFrontendConfig
import uk.gov.hmrc.hmrcfrontend.views.Utils.urlEncode

trait StandardPhaseBanner {

  protected def contactFrontendBetaFeedbackUrl()(implicit
    contactFrontendConfig: ContactFrontendConfig,
    request: RequestHeader
  ) = {
    val queryStringParams: Seq[String] = Seq(
      contactFrontendConfig.serviceId.map(id => "service=" + id),
      contactFrontendConfig.referrerUrl.map(url => "referrerUrl=" + urlEncode(url))
    ).flatten

    val queryString = if (queryStringParams.isEmpty) "" else "?" + queryStringParams.mkString("&")
    contactFrontendConfig.baseUrl.getOrElse("") + "/contact/beta-feedback" + queryString
  }

  def apply(phase: String, url: String)(implicit messages: Messages): PhaseBanner =
    PhaseBanner(
      tag = Some(Tag(content = Text(phase))),
      content = HtmlContent(
        s"""${messages("phase.banner.before")} <a class=\"govuk-link\" href=\"${HtmlFormat.escape(url)}\">${messages(
          "phase.banner.link"
        )}</a> ${messages("phase.banner.after")}"""
      )
    )
}

class StandardBetaBanner extends StandardPhaseBanner {
  def apply(url: String)(implicit messages: Messages): PhaseBanner = apply(phase = "beta", url = url)

  def apply()(implicit
    contactFrontendConfig: ContactFrontendConfig,
    request: RequestHeader,
    messages: Messages
  ): PhaseBanner =
    apply(url = contactFrontendBetaFeedbackUrl())
}

class StandardAlphaBanner extends StandardPhaseBanner {
  def apply(url: String)(implicit messages: Messages): PhaseBanner = apply(phase = "alpha", url = url)
}
