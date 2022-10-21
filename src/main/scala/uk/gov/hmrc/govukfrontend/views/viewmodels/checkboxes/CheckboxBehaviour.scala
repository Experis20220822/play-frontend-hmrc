/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.checkboxes

import play.api.libs.json.{Format, JsError, JsResult, JsString, JsSuccess, JsValue}

sealed trait CheckboxBehaviour

object CheckboxBehaviour {
  implicit object CheckboxBehaviourFormat extends Format[CheckboxBehaviour] {
    override def reads(json: JsValue): JsResult[CheckboxBehaviour] = json match {
      case JsString("exclusive") => JsSuccess(ExclusiveCheckbox)
      case JsString(_)           => JsError("error.expected.validbehaviour")
      case _                     => JsError("error.expected.jsstring")
    }

    override def writes(b: CheckboxBehaviour): JsString = JsString(b match {
      case ExclusiveCheckbox => "exclusive"
    })
  }
}

case object ExclusiveCheckbox extends CheckboxBehaviour {
  override def toString = "exclusive"
}
