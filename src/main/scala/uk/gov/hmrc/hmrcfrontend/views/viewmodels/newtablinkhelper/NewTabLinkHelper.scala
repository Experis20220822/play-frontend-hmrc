/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.newtablinkhelper

case class NewTabLinkHelper(
  text: String = "",
  href: Option[String] = None,
  classList: Option[String] = None
)
