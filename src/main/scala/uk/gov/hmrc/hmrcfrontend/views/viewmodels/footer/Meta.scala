/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.footer

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Meta(
  visuallyHiddenTitle: Option[String] = None,
  content: Content = Empty,
  items: Option[Seq[FooterItem]] = None
)

object Meta {

  implicit val reads: Reads[Meta] = (
    (__ \ "visuallyHiddenTitle").readNullable[String] and
      Content.reads and
      (__ \ "items").readNullable[Seq[FooterItem]]
  )(Meta.apply _)

  implicit val writes: OWrites[Meta] = (
    (__ \ "visuallyHiddenTitle").writeNullable[String] and
      Content.writes and
      (__ \ "items").writeNullable[Seq[FooterItem]]
  )(unlift(Meta.unapply))
}
