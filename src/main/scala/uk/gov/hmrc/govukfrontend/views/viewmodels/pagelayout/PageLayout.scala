/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.pagelayout

import play.twirl.api.Html

case class PageLayout(
  beforeContentBlock: Option[Html],
  contentBlock: Html,
  mainLang: Option[String],
  mainClasses: Option[String]
)
