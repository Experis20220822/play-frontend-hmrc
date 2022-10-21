/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.accessibleautocomplete

import play.api.libs.json.{Json, OFormat}

case class AccessibleAutocomplete(
  defaultValue: Option[String] =
    None, // Please read on the usage of the defaultValue property at https://www.npmjs.com/package/accessible-autocomplete under the `Null options` heading
  showAllValues: Boolean = false,
  autoSelect: Boolean = false
) {
  val dataModule: String = "hmrc-accessible-autocomplete"
}
