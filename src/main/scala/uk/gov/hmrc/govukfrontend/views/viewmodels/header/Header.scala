/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.header

import play.api.libs.json._

final case class Header(
  homepageUrl: Option[String] = None,
  productName: Option[String] = None,
  serviceName: Option[String] = None,
  serviceUrl: Option[String] = None,
  // FIXME: we need the unusual Option[Seq[HeaderNavigation]] to represent JS `undefined` values because None maps to `undefined` nicely.
  // If we refined the type, the correct type would be something like Option[NonEmptySeq[HeaderNavigation]]
  // once https://github.com/alphagov/govuk-frontend/issues/1618 is solved we can think of a better type
  navigation: Option[Seq[HeaderNavigation]] = None,
  navigationClasses: String = "",
  containerClasses: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  menuButtonLabel: Option[String] = None,
  navigationLabel: Option[String] = None,
  assetsPath: Option[String] = None
)

object Header {

  implicit def jsonFormats: OFormat[Header] =
    Json.using[Json.WithDefaultValues].format[Header]
}
