/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.config

import javax.inject.Inject
import play.api.Configuration

class TimeoutDialogConfig @Inject() (configuration: Configuration) {
  def timeoutInSeconds: Int =
    configuration
      .getOptional[Int]("session.timeoutSeconds")
      .orElse(configuration.getOptional[scala.concurrent.duration.Duration]("session.timeout").map(_.toSeconds.toInt))
      .getOrElse(configuration.get[Int]("hmrc-timeout-dialog.defaultTimeoutInSeconds"))

  def countdownInSeconds: Int = configuration.get[Int]("hmrc-timeout-dialog.defaultCountdownInSeconds")

  def enableSynchroniseTabs: Boolean =
    configuration.getOptional[Boolean]("hmrc-timeout-dialog.enableSynchroniseTabs").getOrElse(false)
}
