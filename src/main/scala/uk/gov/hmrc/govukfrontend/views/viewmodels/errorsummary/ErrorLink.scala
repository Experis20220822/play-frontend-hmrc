/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package errorsummary

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class ErrorLink(
  href: Option[String] = None,
  content: Content = Empty,
  attributes: Map[String, String] = Map.empty
)

object ErrorLink {

  def defaultObject: ErrorLink = ErrorLink()

  implicit def jsonReads: Reads[ErrorLink] =
    (
      (__ \ "href").readNullable[String] and
        Content.reads and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(ErrorLink.apply _)

  implicit def jsonWrites: OWrites[ErrorLink] =
    (
      (__ \ "href").writeNullable[String] and
        Content.writes and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(ErrorLink.unapply))

}
