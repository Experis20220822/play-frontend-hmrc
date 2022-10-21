/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.footer

import play.api.libs.functional.syntax.unlift
import play.api.libs.json.{OWrites, Reads}
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.Content

final case class Copyright(content: Content)

object Copyright {
  implicit val reads: Reads[Copyright]    = Content.reads.map(c => Copyright(c))
  implicit val writes: OWrites[Copyright] = Content.writes.contramap(unlift(Copyright.unapply))
}
