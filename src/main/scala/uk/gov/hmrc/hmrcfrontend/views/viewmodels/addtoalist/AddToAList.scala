/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.addtoalist

import play.api.libs.json.{Json, OFormat}
import uk.gov.hmrc.hmrcfrontend.views.viewmodels.language.{En, Language}

case class AddToAList(
  itemList: Seq[ListItem] = Seq.empty,
  itemType: Option[ItemType] = None,
  itemSize: ItemSize = Short,
  formAction: Option[String] = None,
  hintText: Option[String] = None,
  language: Language = En
)

object AddToAList {
  implicit def jsonFormats: OFormat[AddToAList] = Json.using[Json.WithDefaultValues].format[AddToAList]
}
