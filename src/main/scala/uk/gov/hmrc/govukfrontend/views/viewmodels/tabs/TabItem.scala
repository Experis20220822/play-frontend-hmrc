/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.tabs

import play.api.libs.json._

final case class TabItem(
  id: Option[String] = None,
  label: String = "",
  attributes: Map[String, String] = Map.empty,
  panel: TabPanel = TabPanel()
)

object TabItem {

  implicit def jsonFormats: OFormat[TabItem] =
    Json.using[Json.WithDefaultValues].format[TabItem]

}
