/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.implicits

import uk.gov.hmrc.govukfrontend.views.viewmodels.checkboxes.CheckboxItem
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Text
import uk.gov.hmrc.govukfrontend.views.viewmodels.radios.RadioItem

trait RichSeqStringTupleSupport {
  implicit class RichSeqStringTuple(items: Seq[(String, String)]) {
    def toRadioItems: Seq[RadioItem] =
      items map tupleToRadioItem

    private def tupleToRadioItem(tuple: (String, String)): RadioItem =
      RadioItem(
        content = Text(tuple._2),
        value = Some(tuple._1)
      )

    def toCheckboxItems: Seq[CheckboxItem] =
      items map tupleToCheckboxItem

    private def tupleToCheckboxItem(tuple: (String, String)): CheckboxItem =
      CheckboxItem(
        content = Text(tuple._2),
        value = tuple._1
      )
  }
}
