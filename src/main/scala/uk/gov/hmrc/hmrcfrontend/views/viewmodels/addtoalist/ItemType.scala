/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.addtoalist

import play.api.libs.json.{Json, OFormat}

case class ItemType(
  singular: String,
  plural: String
)

object ItemType {
  implicit def jsonFormats: OFormat[ItemType] = Json.using[Json.WithDefaultValues].format[ItemType]
}
