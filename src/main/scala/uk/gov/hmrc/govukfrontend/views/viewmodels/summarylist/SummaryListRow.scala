/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package summarylist

import play.api.libs.json._

final case class SummaryListRow(
  key: Key = Key(),
  value: Value = Value(),
  classes: String = "",
  actions: Option[Actions] = None
)

object SummaryListRow {

  implicit def jsonFormats: OFormat[SummaryListRow] =
    Json.using[Json.WithDefaultValues].format[SummaryListRow]
}
