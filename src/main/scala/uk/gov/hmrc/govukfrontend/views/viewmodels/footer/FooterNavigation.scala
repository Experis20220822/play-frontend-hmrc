/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.footer

import play.api.libs.json._

final case class FooterNavigation(
  title: Option[String] = None,
  columns: Option[Int] = None,
  items: Seq[FooterItem] = Seq.empty,
  width: Option[String] = None
)

object FooterNavigation {

  implicit def jsonFormats: OFormat[FooterNavigation] =
    Json.using[Json.WithDefaultValues].format[FooterNavigation]
}
