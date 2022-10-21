/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package hint

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Hint(
  id: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  content: Content = Empty
)

object Hint {

  def defaultObject: Hint = Hint()

  implicit def jsonReads: Reads[Hint] =
    (
      (__ \ "id").readNullable[String] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        Content.reads
    )(Hint.apply _)

  implicit def jsonWrites: OWrites[Hint] =
    (
      (__ \ "id").writeNullable[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writes
    )(unlift(Hint.unapply))

}
