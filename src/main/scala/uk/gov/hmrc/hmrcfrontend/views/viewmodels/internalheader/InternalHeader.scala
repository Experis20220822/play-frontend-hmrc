/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.internalheader

import play.api.libs.json._
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{En, Language}

case class InternalHeader(
  homepageUrl: String = "/",
  serviceName: Option[String] = None,
  serviceUrl: String = "",
  language: Language = En
)

object InternalHeader {

  implicit def jsonFormats: OFormat[InternalHeader] = Json.using[Json.WithDefaultValues].format[InternalHeader]
}
