/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.addtoalist

import play.api.libs.json.{Format, JsError, JsResult, JsString, JsSuccess, JsValue}

trait ItemSize {
  def suffix: String
}

object ItemSize {
  implicit object ItemSizeFormat extends Format[ItemSize] {
    override def reads(json: JsValue): JsResult[ItemSize] = json match {
      case JsString("short") => JsSuccess(Short)
      case JsString("long")  => JsSuccess(Long)
      case JsString(_)       => JsError("error.expected.validitemsize")
      case _                 => JsError("error.expected.jsstring")
    }

    override def writes(o: ItemSize): JsString = JsString(o.suffix)
  }
}
