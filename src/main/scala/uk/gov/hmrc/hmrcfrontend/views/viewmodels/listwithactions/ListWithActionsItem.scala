/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.listwithactions

import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class ListWithActionsItem(
  name: Content = Empty,
  actions: Seq[ListWithActionsAction] = Nil,
  classes: Option[String] = None
)

object ListWithActionsItem {
  implicit def jsonFormats: OFormat[ListWithActionsItem] =
    Json.using[Json.WithDefaultValues].format[ListWithActionsItem]
}
