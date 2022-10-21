/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.implicits

import uk.gov.hmrc.govukfrontend.views.viewmodels.fieldset.{Fieldset, Legend}

trait RichLegendSupport {
  implicit class RichLegend(legend: Legend) {
    def toFieldset: Fieldset =
      Fieldset(
        legend = Some(legend)
      )
  }
}
