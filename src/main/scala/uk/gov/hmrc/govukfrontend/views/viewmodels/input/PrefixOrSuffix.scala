/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.input

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

case class PrefixOrSuffix(
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object PrefixOrSuffix {

  def defaultObject: PrefixOrSuffix = PrefixOrSuffix()

  implicit def jsonReads: Reads[PrefixOrSuffix] =
    (
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(PrefixOrSuffix.apply _)

  implicit def jsonWrites: OWrites[PrefixOrSuffix] =
    (
      (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(PrefixOrSuffix.unapply))
}
