/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.controllers

import javax.inject.{Inject, Singleton}
import play.api.Configuration
import play.api.i18n.Lang
import play.api.mvc._
import uk.gov.hmrc.hmrcfrontend.config.LanguageConfig
import uk.gov.hmrc.play.language.{LanguageController => PlayLanguageController, LanguageUtils}

@Singleton
case class LanguageController @Inject() (
  configuration: Configuration,
  languageUtils: LanguageUtils,
  cc: ControllerComponents,
  languageConfig: LanguageConfig
) extends PlayLanguageController(languageUtils, cc) {
  import languageConfig._

  override def fallbackURL: String = languageConfig.fallbackURL

  override protected def languageMap: Map[String, Lang] =
    Map(en -> Lang(en), cy -> Lang(cy))
}
