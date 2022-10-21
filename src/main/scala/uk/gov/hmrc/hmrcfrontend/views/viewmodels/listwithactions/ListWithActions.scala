/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.listwithactions

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class ListWithActions(
  items: Seq[ListWithActionsItem] = Nil,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object ListWithActions {

  def defaultObject: ListWithActions = ListWithActions()

  implicit def jsonReads: Reads[ListWithActions] = (
    (__ \ "items").readWithDefault[Seq[ListWithActionsItem]](defaultObject.items)(
      forgivingSeqReads[ListWithActionsItem]
    ) and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads)
  )(ListWithActions.apply _)

  implicit def jsonWrites: OWrites[ListWithActions] = Json.writes[ListWithActions]
}
