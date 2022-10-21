/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.config

import javax.inject.Inject
import uk.gov.hmrc.hmrcfrontend.controllers.routes.Assets
import uk.gov.hmrc.hmrcfrontend.views.HmrcFrontendDependency

class AssetsConfig @Inject() () {
  private val hmrcFrontendVersion = HmrcFrontendDependency.hmrcFrontendVersion

  lazy val html5ShivJsUrl: String        = Assets.at("vendor/html5shiv.min.js").url
  lazy val hmrcFrontendCssUrl: String    = hmrcFrontendAssetUrl(s"hmrc-frontend-$hmrcFrontendVersion.min.css")
  lazy val hmrcFrontendIe8CssUrl: String = hmrcFrontendAssetUrl(s"hmrc-frontend-ie8-$hmrcFrontendVersion.min.css")
  lazy val hmrcFrontendJsUrl: String     = hmrcFrontendAssetUrl(s"hmrc-frontend-$hmrcFrontendVersion.min.js")
  lazy val autocompleteJsUrl: String     = hmrcFrontendAssetUrl(s"accessible-autocomplete-$hmrcFrontendVersion.js")
  lazy val autocompleteCssUrl: String    = hmrcFrontendAssetUrl(s"accessible-autocomplete-$hmrcFrontendVersion.css")

  private def hmrcFrontendAssetUrl(filename: String) = Assets.at(filename).url
}
