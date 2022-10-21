/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views

import uk.gov.hmrc.govukfrontend.views.implicits._

trait Implicits
    extends RichCharacterCountSupport
    with RichCheckboxesSupport
    with RichFormErrorsSupport
    with RichHtmlSupport
    with RichInputSupport
    with RichOptionStringSupport
    with RichRadiosSupport
    with RichSelectSupport
    with RichStringSupport
    with RichTextareaSupport
    with RichSeqStringTupleSupport
    with RichLegendSupport
    with RichActionItemSupport

object Implicits extends Implicits
