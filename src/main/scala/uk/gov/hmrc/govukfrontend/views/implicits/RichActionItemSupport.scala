/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.implicits

import uk.gov.hmrc.govukfrontend.views.viewmodels.summarylist.{ActionItem, Actions}

trait RichActionItemSupport {
  implicit class RichActionItem(actionItem: ActionItem) {
    def toActions: Actions = Actions(items =
      Seq(
        actionItem
      )
    )
  }
}
