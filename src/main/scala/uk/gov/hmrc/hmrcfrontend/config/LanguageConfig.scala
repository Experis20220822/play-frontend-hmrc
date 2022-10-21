/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.config

import javax.inject.Inject
import play.api.Configuration

class LanguageConfig @Inject() (config: Configuration) {
  val en: String = "en"
  val cy: String = "cy"

  val fallbackURL: String = config.get[String]("language.fallback.url")
}
