/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.footer

import play.api.libs.json._
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{En, Language}

case class Footer(
  meta: Option[Meta] = None,
  navigation: Seq[FooterNavigation] = Seq.empty,
  containerClasses: String = "",
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  language: Language = En
)

object Footer {

  implicit def jsonFormats: Format[Footer] = Json.using[Json.WithDefaultValues].format[Footer]
}
