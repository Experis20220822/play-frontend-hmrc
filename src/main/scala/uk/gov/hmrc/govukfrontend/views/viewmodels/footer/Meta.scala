/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package footer

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{Content, Empty}

final case class Meta(
  visuallyHiddenTitle: Option[String] = None,
  content: Content                    = Empty,
  items: Seq[FooterItem]              = Nil
)

object Meta {

  implicit val reads: Reads[Meta] = (
    (__ \ "visuallyHiddenTitle").readNullable[String] and
      Content.reads and
      (__ \ "items").readWithDefault[Seq[FooterItem]](Nil)
  )(Meta.apply _)

  implicit val writes: OWrites[Meta] = (
    (__ \ "visuallyHiddenTitle").writeNullable[String] and
      Content.writes and
      (__ \ "items").write[Seq[FooterItem]]
  )(unlift(Meta.unapply))
}
