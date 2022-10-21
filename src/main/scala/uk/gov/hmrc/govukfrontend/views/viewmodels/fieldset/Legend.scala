/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package fieldset

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Legend(
  content: Content = Empty,
  classes: String = "",
  isPageHeading: Boolean = false
)

object Legend {

  def defaultObject: Legend = Legend()

  implicit def jsonReads: Reads[Legend] =
    (
      Content.reads and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "isPageHeading").readWithDefault[Boolean](defaultObject.isPageHeading)
    )(Legend.apply _)

  implicit def jsonWrites: OWrites[Legend] =
    (
      Content.writes and
        (__ \ "classes").write[String] and
        (__ \ "isPageHeading").write[Boolean]
    )(unlift(Legend.unapply))

}
