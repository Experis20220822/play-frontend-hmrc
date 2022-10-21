/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.currencyinput

import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.hint.Hint
import uk.gov.hmrc.govukfrontend.views.viewmodels.label.Label
import uk.gov.hmrc.govukfrontend.views.viewmodels.errormessage.ErrorMessage

case class CurrencyInput(
  id: String = "",
  name: String = "",
  describedBy: Option[String] = None,
  value: Option[String] = None,
  label: Label = Label(),
  hint: Option[Hint] = None,
  errorMessage: Option[ErrorMessage] = None,
  classes: String = "",
  autocomplete: Option[String] = None,
  attributes: Map[String, String] = Map.empty
)

object CurrencyInput {

  implicit def jsonFormats: OFormat[CurrencyInput] = Json.using[Json.WithDefaultValues].format[CurrencyInput]
}
