/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.pageheading

import play.api.libs.json._

case class PageHeading(
  text: String = "",
  section: Option[String] = None,
  language: Option[String] = None,
  classes: Option[String] = None,
  headingClasses: Option[String] = None,
  captionClasses: Option[String] = None
)

object PageHeading {
  implicit def jsonFormats: OFormat[PageHeading] = Json.using[Json.WithDefaultValues].format[PageHeading]
}
