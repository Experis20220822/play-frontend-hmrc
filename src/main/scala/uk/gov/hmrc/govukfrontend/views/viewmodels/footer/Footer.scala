/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.footer

import play.api.libs.functional.syntax._
import play.api.libs.json._

case class Footer(
  meta: Option[Meta] = None,
  navigation: Seq[FooterNavigation] = Seq.empty,
  containerClasses: String = "",
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  contentLicence: Option[ContentLicence] = None,
  copyright: Option[Copyright] = None
)

object Footer {

  def defaultObject: Footer = Footer()

  implicit def jsonReads: Reads[Footer] =
    (
      (__ \ "meta").readNullable[Meta] and
        (__ \ "navigation").readWithDefault[Seq[FooterNavigation]](defaultObject.navigation) and
        (__ \ "containerClasses").readWithDefault[String](defaultObject.containerClasses) and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        (__ \ "contentLicence").readNullable[ContentLicence] and
        (__ \ "copyright").readNullable[Copyright]
    )(Footer.apply _)

  implicit def jsonWrites: OWrites[Footer] =
    (
      (__ \ "meta").writeNullable[Meta] and
        (__ \ "navigation").write[Seq[FooterNavigation]] and
        (__ \ "containerClasses").write[String] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        (__ \ "contentLicence").writeNullable[ContentLicence] and
        (__ \ "copyright").writeNullable[Copyright]
    )(unlift(Footer.unapply))

}
