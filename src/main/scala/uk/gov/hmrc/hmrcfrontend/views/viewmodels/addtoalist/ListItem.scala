/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.addtoalist

import play.api.libs.json.{Json, OFormat}

case class ListItem(
  name: String,
  changeUrl: String,
  removeUrl: String
)

object ListItem {
  implicit def jsonFormats: OFormat[ListItem] = Json.using[Json.WithDefaultValues].format[ListItem]
}
