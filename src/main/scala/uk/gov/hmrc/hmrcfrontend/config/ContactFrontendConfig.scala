/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.config

import javax.inject.Inject
import play.api.Configuration
import play.api.mvc.RequestHeader

class ContactFrontendConfig @Inject() (config: Configuration) {
  private val platformHost: Option[String] =
    config.getOptional[String]("platform.frontend.host")

  def baseUrl: Option[String]   =
    platformHost.orElse(config.getOptional[String]("contact-frontend.host"))
  def serviceId: Option[String] =
    config.getOptional[String]("contact-frontend.serviceId")

  def referrerUrl(implicit request: RequestHeader): Option[String] =
    Some(s"${platformHost
      .getOrElse("")}${pathWithQuerystring(request)}")
}
