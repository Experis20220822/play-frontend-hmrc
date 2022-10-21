/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package table

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.supportfrontend.views.IntString
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class TableRow(
  content: Content = Empty,
  format: Option[String] = None,
  classes: String = "",
  colspan: Option[Int] = None,
  rowspan: Option[Int] = None,
  attributes: Map[String, String] = Map.empty
)

object TableRow {

  def defaultObject: TableRow = TableRow()

  implicit def jsonReads: Reads[TableRow] =
    (
      Content.reads and
        (__ \ "format").readNullable[String] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "colspan").readNullable[IntString].int and
        (__ \ "rowspan").readNullable[IntString].int and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(TableRow.apply _)

  implicit def jsonWrites: OWrites[TableRow] =
    (
      Content.writes and
        (__ \ "format").writeNullable[String] and
        (__ \ "classes").write[String] and
        (__ \ "colspan").writeNullable[Int] and
        (__ \ "rowspan").writeNullable[Int] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(TableRow.unapply))

}
