/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.banner

import play.api.libs.json._
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{En, Language}

case class Banner(
  language: Language = En
)

object Banner {

  implicit def jsonFormats: OFormat[Banner] = Json.using[Json.WithDefaultValues].format[Banner]
}
