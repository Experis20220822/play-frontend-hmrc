/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.breadcrumbs

import play.api.libs.json.{Json, OWrites, Reads}
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class Breadcrumbs(
  items: Seq[BreadcrumbsItem] = Nil,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  collapseOnMobile: Boolean = false
)

object Breadcrumbs {

  def defaultObject: Breadcrumbs = Breadcrumbs()

  implicit def jsonReads: Reads[Breadcrumbs] =
    ((__ \ "items").readWithDefault[Seq[BreadcrumbsItem]](defaultObject.items) and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads) and
      (__ \ "collapseOnMobile").readWithDefault[Boolean](defaultObject.collapseOnMobile))(Breadcrumbs.apply _)

  implicit def jsonWrites: OWrites[Breadcrumbs] = Json.writes[Breadcrumbs]
}
