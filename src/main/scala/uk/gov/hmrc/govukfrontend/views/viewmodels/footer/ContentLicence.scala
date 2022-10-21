/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.footer

import play.api.libs.functional.syntax.unlift
import play.api.libs.json.{OWrites, Reads, __}
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Content

final case class ContentLicence(content: Content)

object ContentLicence {
  implicit val reads: Reads[ContentLicence]    = Content.reads.map(c => ContentLicence(c))
  implicit val writes: OWrites[ContentLicence] = Content.writes.contramap(unlift(ContentLicence.unapply))
}
