/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.footer

import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

class FooterContent(
  val html: Content = Empty,
  val text: Option[String] = None
)
