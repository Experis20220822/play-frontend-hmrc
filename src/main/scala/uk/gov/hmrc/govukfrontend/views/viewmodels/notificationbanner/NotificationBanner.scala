/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.notificationbanner

import play.api.libs.functional.syntax._
import play.api.libs.json.{OWrites, Reads, __}
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats.attributesReads
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

case class NotificationBanner(
  content: Content = Empty,
  bannerType: Option[String] = None,
  role: Option[String] = None,
  title: Content = Empty,
  titleId: Option[String] = None,
  disableAutoFocus: Option[Boolean] = None,
  classes: String = "",
  titleHeadingLevel: Option[Int] = None,
  attributes: Map[String, String] = Map.empty
)

object NotificationBanner {

  def defaultObject: NotificationBanner = NotificationBanner()

  implicit def jsonReads: Reads[NotificationBanner] =
    (
      Content.reads and
        (__ \ "type").readNullable[String] and
        (__ \ "role").readNullable[String] and
        Content.readsHtmlOrText((__ \ "titleHtml"), (__ \ "titleText")) and
        (__ \ "titleId").readNullable[String] and
        (__ \ "disableAutoFocus").readNullable[Boolean] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "titleHeadingLevel").readNullable[Int] and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads)
    )(NotificationBanner.apply _)

  implicit def jsonWrites: OWrites[NotificationBanner] =
    (
      Content.writes and
        (__ \ "type").writeNullable[String] and
        (__ \ "role").writeNullable[String] and
        Content.writesContent("titleHtml", "titleText") and
        (__ \ "titleId").writeNullable[String] and
        (__ \ "disableAutoFocus").writeNullable[Boolean] and
        (__ \ "classes").write[String] and
        (__ \ "titleHeadingLevel").writeNullable[Int] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(NotificationBanner.unapply))
}
