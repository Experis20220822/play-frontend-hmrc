/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package summarylist

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class ActionItem(
  href: String = "",
  content: Content = Empty,
  visuallyHiddenText: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object ActionItem {

  def defaultObject: ActionItem = ActionItem()

  implicit def jsonReads: Reads[ActionItem] =
    (
      (__ \ "href").readWithDefault[String](defaultObject.href) and
        Content.reads and
        (__ \ "visuallyHiddenText").readNullable[String] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(ActionItem.apply _)

  implicit def jsonWrites: OWrites[ActionItem] =
    (
      (__ \ "href").write[String] and
        Content.writes and
        (__ \ "visuallyHiddenText").writeNullable[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(ActionItem.unapply))

}
