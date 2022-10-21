/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.config

import javax.inject.Inject
import play.api.i18n.Messages
import play.api.mvc.RequestHeader
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.footer.FooterItem
import uk.gov.hmrc.hmrcfrontend.config.AccessibilityStatementConfig

class HmrcFooterItems @Inject() (accessibilityStatementConfig: AccessibilityStatementConfig) {
  def get(implicit messages: Messages, request: RequestHeader): Seq[FooterItem] =
    getWithAccessibilityStatementUrl(None)

  private[views] def getWithAccessibilityStatementUrl(
    accessibilityStatementUrl: Option[String]
  )(implicit messages: Messages, request: RequestHeader): Seq[FooterItem] =
    Seq(
      footerItemForKey("cookies"),
      accessibilityLink(accessibilityStatementUrl),
      footerItemForKey("privacy"),
      footerItemForKey("termsConditions"),
      footerItemForKey("govukHelp"),
      footerItemForKey("contact"),
      footerItemForKey("welshHelp", attributes = Map("lang" -> "cy", "hreflang" -> "cy"))
    ).flatten

  private def accessibilityLink(
    accessibilityStatementUrl: Option[String] = None
  )(implicit messages: Messages, request: RequestHeader): Option[FooterItem] =
    accessibilityStatementUrl
      .orElse(accessibilityStatementConfig.url)
      .map(href => FooterItem(Some(messages("footer.accessibility.text")), Some(href)))

  private def footerItemForKey(item: String, attributes: Map[String, String] = Map.empty)(implicit
    messages: Messages
  ): Option[FooterItem] =
    Some(
      FooterItem(
        text = Some(messages(s"footer.$item.text")),
        href = Some(messages(s"footer.$item.url")),
        attributes = attributes
      )
    )
}
