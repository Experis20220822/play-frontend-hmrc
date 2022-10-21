/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package summarylist

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Key(content: Content = Empty, classes: String = "")

object Key {

  def defaultObject: Key = Key()

  implicit def jsonReads: Reads[Key] =
    (
      Content.reads and
        (__ \ "classes").readWithDefault[String](defaultObject.classes)
    )(Key.apply _)

  implicit def jsonWrites: OWrites[Key] =
    (
      Content.writes and
        (__ \ "classes").write[String]
    )(unlift(Key.unapply))

}
