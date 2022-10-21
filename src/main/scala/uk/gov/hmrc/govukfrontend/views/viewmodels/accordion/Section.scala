/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package accordion

import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Content._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Section(
  headingContent: Content = Empty,
  summaryContent: Content = Empty,
  content: Content = Empty,
  expanded: Boolean = false
)

object Section {

  def defaultObject: Section = Section()

  implicit def jsonReads: Reads[Section] =
    (
      readsHtmlOrText((__ \ "heading" \ "html"), (__ \ "heading" \ "text")) and
        readsHtmlOrText((__ \ "summary" \ "html"), (__ \ "summary" \ "text")) and
        readsHtmlOrText((__ \ "content" \ "html"), (__ \ "content" \ "text")) and
        (__ \ "expanded").readWithDefault[Boolean](defaultObject.expanded)
    )(Section.apply _)

  implicit def jsonWrites: OWrites[Section] = new OWrites[Section] {
    override def writes(section: Section): JsObject = Json.obj(
      "heading"  -> writesContent().writes(section.headingContent),
      "summary"  -> writesContent().writes(section.summaryContent),
      "content"  -> writesContent().writes(section.content),
      "expanded" -> section.expanded
    )
  }
}
