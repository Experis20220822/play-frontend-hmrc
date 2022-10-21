/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.tabs

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class Tabs(
  id: Option[String] = None,
  idPrefix: Option[String] = None,
  title: String = "Contents",
  items: Seq[TabItem] = Seq.empty,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object Tabs {

  def defaultObject: Tabs = Tabs()

  implicit def jsonReads: Reads[Tabs] = (
    (__ \ "id").readNullable[String] and
      (__ \ "idPrefix").readNullable[String] and
      (__ \ "title").readWithDefault[String](defaultObject.title) and
      (__ \ "items").readWithDefault[Seq[TabItem]](defaultObject.items)(forgivingSeqReads[TabItem]) and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads)
  )(Tabs.apply _)

  implicit def jsonWrites: OWrites[Tabs] = Json.writes[Tabs]
}
