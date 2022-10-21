/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.config

import play.api.i18n.Messages
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Text
import uk.gov.hmrc.govukfrontend.views.viewmodels.radios.RadioItem

object HmrcYesNoRadioItems {
  def apply()(implicit messages: Messages): Seq[RadioItem] =
    Seq(
      RadioItem(value = Some("true"), content = Text(messages("radios.yesnoitems.yes"))),
      RadioItem(value = Some("false"), content = Text(messages("radios.yesnoitems.no")))
    )
}
