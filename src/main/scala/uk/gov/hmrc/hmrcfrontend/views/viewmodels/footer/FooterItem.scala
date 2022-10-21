/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.footer

import play.api.libs.json._

final case class FooterItem(
  text: Option[String] = None,
  href: Option[String] = None,
  attributes: Map[String, String] = Map.empty
)

object FooterItem {

  implicit def jsonFormats: Format[FooterItem] = Json.using[Json.WithDefaultValues].format[FooterItem]
}
