/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.listwithactions

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class ListWithActionsAction(
  href: String = "",
  content: Content = Empty,
  visuallyHiddenText: Option[String] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object ListWithActionsAction {

  def defaultObject: ListWithActionsAction = ListWithActionsAction()

  implicit def jsonReads: Reads[ListWithActionsAction] =
    (
      (__ \ "href").readWithDefault[String](defaultObject.href) and
        Content.reads and
        (__ \ "visuallyHiddenText").readNullable[String] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(ListWithActionsAction.apply _)

  implicit def jsonWrites: OWrites[ListWithActionsAction] =
    (
      (__ \ "href").write[String] and
        Content.writes and
        (__ \ "visuallyHiddenText").writeNullable[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(ListWithActionsAction.unapply))

}
