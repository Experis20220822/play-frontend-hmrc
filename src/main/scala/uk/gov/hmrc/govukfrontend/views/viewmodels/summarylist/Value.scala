/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package summarylist

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Value(content: Content = Empty, classes: String = "")

object Value {

  def defaultObject: Value = Value()

  implicit def jsonReads: Reads[Value] =
    (
      Content.reads and
        (__ \ "classes").readWithDefault[String](defaultObject.classes)
    )(Value.apply _)

  implicit def jsonWrites: OWrites[Value] =
    (
      Content.writes and
        (__ \ "classes").write[String]
    )(unlift(Value.unapply))

}
