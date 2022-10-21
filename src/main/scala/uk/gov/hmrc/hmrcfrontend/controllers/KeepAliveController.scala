/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._

@Singleton
class KeepAliveController @Inject() (cc: ControllerComponents) extends AbstractController(cc) {
  def keepAlive: Action[AnyContent] = Action(NoContent)
}
