/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.newtablink

import play.api.libs.json.{Format, Json, OFormat}

case class NewTabLink(
  text: String = "",
  href: Option[String] = None,
  language: Option[String] = None,
  classList: Option[String] = None
)

object NewTabLink {

  implicit def jsonFormats: OFormat[NewTabLink] = Json.using[Json.WithDefaultValues].format[NewTabLink]
}
