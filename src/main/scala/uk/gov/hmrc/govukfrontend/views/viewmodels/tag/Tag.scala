/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package tag

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Tag(
  content: Content = Empty,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object Tag {

  def defaultObject: Tag = Tag()

  implicit def jsonReads: Reads[Tag] =
    (
      Content.reads and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(Tag.apply _)

  implicit def jsonWrites: OWrites[Tag] =
    (
      Content.writes and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(Tag.unapply))

}
