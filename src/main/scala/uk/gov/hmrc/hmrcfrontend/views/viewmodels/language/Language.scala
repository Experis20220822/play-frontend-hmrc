/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views.viewmodels.language

import play.api.libs.json._

trait Language extends Ordered[Language] {
  def code: String

  def name: String

  def compare(that: Language): Int = Language.LanguageOrdering.compare(this, that)
}

object Language {

  implicit object LanguageFormat extends Format[Language] {
    override def reads(json: JsValue): JsResult[Language] = json match {
      case JsString("en") => JsSuccess(En)
      case JsString("cy") => JsSuccess(Cy)
      case JsString(_)    => JsError("error.expected.validlanguage")
      case _              => JsError("error.expected.jsstring")
    }

    override def writes(o: Language): JsString = JsString(o match {
      case Cy => "cy"
      case En => "en"
    })
  }

  implicit object LanguageOrdering extends Ordering[Language] { // Ordered/Ordering are invariant in type parameters, so cannot be mixed into trait to order implementations of the trait
    def compare(x: Language, y: Language): Int =
      (x, y) match {
        case (En, En) => 0
        case (En, _)  => -1
        case (_, En)  => 1
        case (_, _)   => x.name compare y.name
      }
  }

}
