/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.panel

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.supportfrontend.views.IntString
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

case class Panel(
  headingLevel: Int = 1,
  classes: String = "",
  attributes: Map[String, String] = Map.empty,
  title: Content = Empty,
  content: Content = Empty
)

object Panel {

  def defaultObject: Panel = Panel()

  implicit def jsonReads: Reads[Panel] =
    (
      (__ \ "headingLevel").readWithDefault[IntString](IntString(defaultObject.headingLevel)).int and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)(attributesReads) and
        Content.readsHtmlOrText((__ \ "titleHtml"), (__ \ "titleText")) and
        Content.reads
    )(Panel.apply _)

  implicit def jsonWrites: OWrites[Panel] =
    (
      (__ \ "headingLevel").write[Int] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]] and
        Content.writesContent("titleHtml", "titleText") and
        Content.writes
    )(unlift(Panel.unapply))

}
