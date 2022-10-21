/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.config

import java.net.URLEncoder

import javax.inject.Inject
import play.api.Configuration
import play.api.mvc.RequestHeader

class AccessibilityStatementConfig @Inject() (config: Configuration) {
  val platformHost: Option[String]                      =
    config.getOptional[String]("platform.frontend.host")
  val accessibilityStatementHost: Option[String]        =
    platformHost.orElse(config.getOptional[String]("accessibility-statement.host"))
  val accessibilityStatementPath: Option[String]        =
    config.getOptional[String]("accessibility-statement.path")
  val accessibilityStatementServicePath: Option[String] =
    config.getOptional[String]("accessibility-statement.service-path")

  def url(implicit request: RequestHeader): Option[String] =
    for {
      host        <- accessibilityStatementHost
      path        <- accessibilityStatementPath
      servicePath <- accessibilityStatementServicePath
    } yield s"$host$path$servicePath$query"

  private def query(implicit request: RequestHeader): String = {
    val referrerUrl = URLEncoder.encode(s"${platformHost.getOrElse("")}${pathWithQuerystring(request)}", "UTF-8")
    s"?referrerUrl=$referrerUrl"
  }
}
