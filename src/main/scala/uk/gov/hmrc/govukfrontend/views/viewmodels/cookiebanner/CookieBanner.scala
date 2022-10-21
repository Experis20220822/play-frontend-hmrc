/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.cookiebanner

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class CookieBanner(
  id: String = "",
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  hidden: Boolean = false,
  ariaLabel: Option[String] = None,
  messages: Seq[Message] = Seq.empty
)

object CookieBanner {

  def defaultObject: CookieBanner = CookieBanner()

  implicit def jsonReads: Reads[CookieBanner] = (
    (__ \ "id").readWithDefault[String](defaultObject.id) and
      (__ \ "classes").readWithDefault[String](defaultObject.classes) and
      (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads) and
      (__ \ "hidden").readWithDefault[Boolean](defaultObject.hidden) and
      (__ \ "ariaLabel").readNullable[String] and
      (__ \ "messages").read[Seq[Message]]
  )(CookieBanner.apply _)

  implicit def jsonWrites: OWrites[CookieBanner] = (
    (__ \ "id").write[String] and
      (__ \ "classes").write[String] and
      (__ \ "attributes").write[Map[String, String]] and
      (__ \ "hidden").write[Boolean] and
      (__ \ "ariaLabel").writeNullable[String] and
      (__ \ "messages").write[Seq[Message]]
  )(unlift(CookieBanner.unapply))
}
