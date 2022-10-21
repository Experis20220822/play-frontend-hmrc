/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.summarylist

import play.api.libs.json._
import play.api.libs.functional.syntax._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class SummaryList(
  rows: Seq[SummaryListRow] = Nil,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object SummaryList {

  def defaultObject: SummaryList = SummaryList()

  implicit def jsonReads: Reads[SummaryList] = (
    (__ \ "rows").readWithDefault[Seq[SummaryListRow]](defaultObject.rows)(forgivingSeqReads[SummaryListRow]) and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads)
  )(SummaryList.apply _)

  implicit def jsonWrites: OWrites[SummaryList] = Json.writes[SummaryList]
}
