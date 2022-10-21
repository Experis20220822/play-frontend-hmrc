/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels
package summarylist

import play.api.libs.json._

final case class Actions(classes: String = "", items: Seq[ActionItem] = Nil)

object Actions {

  implicit def jsonFormats: OFormat[Actions] =
    Json.using[Json.WithDefaultValues].format[Actions]

}
