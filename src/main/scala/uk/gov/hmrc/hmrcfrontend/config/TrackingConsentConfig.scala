/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.config

import javax.inject.Inject
import play.api.Configuration

class TrackingConsentConfig @Inject() (config: Configuration) {
  val platformHost: Option[String]        =
    config.getOptional[String]("platform.frontend.host")
  val trackingConsentHost: Option[String] =
    platformHost.map(_ => "").orElse(config.getOptional[String]("tracking-consent-frontend.host"))
  val trackingConsentPath: Option[String] =
    config.getOptional[String]("tracking-consent-frontend.path")
  val optimizelyGtmPath: Option[String]   =
    config.getOptional[String]("tracking-consent-frontend.optimizely-gtm-path")
  val gtmContainer: Option[String]        = config.getOptional[String]("tracking-consent-frontend.gtm.container")

  def trackingUrl(): Option[String] =
    for {
      host <- trackingConsentHost
      path <- trackingConsentPath
      _    <- gtmContainer
    } yield s"$host$path"

  def optimizelyUrl: Option[String] =
    for {
      baseUrl   <- config.getOptional[String]("optimizely.url")
      projectId <- config.getOptional[String]("optimizely.projectId")
    } yield s"$baseUrl$projectId.js"

  def optimizelyGtmUrl(): Option[String] =
    for {
      host <- trackingConsentHost
      path <- optimizelyGtmPath
      _    <- gtmContainer
    } yield s"$host$path"
}
