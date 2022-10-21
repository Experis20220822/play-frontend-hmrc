/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.input

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._
import uk.gov.hmrc.govukfrontend.views.viewmodels.errormessage.ErrorMessage
import uk.gov.hmrc.govukfrontend.views.viewmodels.hint.Hint
import uk.gov.hmrc.govukfrontend.views.viewmodels.label.Label

case class Input(
  id: String = "",
  name: String = "",
  inputType: String = "text",
  inputmode: Option[String] = None,
  describedBy: Option[String] = None,
  value: Option[String] = None,
  label: Label = Label(),
  hint: Option[Hint] = None,
  errorMessage: Option[ErrorMessage] = None,
  formGroupClasses: String = "",
  classes: String = "",
  autocomplete: Option[String] = None,
  pattern: Option[String] = None,
  attributes: Map[String, String] = Map.empty,
  spellcheck: Option[Boolean] = None,
  prefix: Option[PrefixOrSuffix] = None,
  suffix: Option[PrefixOrSuffix] = None
)

object Input {

  def defaultObject: Input = Input()

  implicit def jsonReads: Reads[Input] =
    (
      (__ \ "id").readWithDefault[String](defaultObject.id) and
        (__ \ "name").readWithDefault[String](defaultObject.name) and
        (__ \ "type").readWithDefault[String](defaultObject.inputType) and
        (__ \ "inputmode").readNullable[String] and
        (__ \ "describedBy").readNullable[String] and
        (__ \ "value").readNullable[String] and
        (__ \ "label").readWithDefault[Label](defaultObject.label) and
        (__ \ "hint").readNullable[Hint] and
        (__ \ "errorMessage").readNullable[ErrorMessage] and
        readsFormGroupClasses and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "autocomplete").readNullable[String] and
        (__ \ "pattern").readNullable[String] and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes) and
        (__ \ "spellcheck").readNullable[Boolean] and
        (__ \ "prefix").readNullable[PrefixOrSuffix] and
        (__ \ "suffix").readNullable[PrefixOrSuffix]
    )(Input.apply _)

  implicit def jsonWrites: OWrites[Input] =
    (
      (__ \ "id").write[String] and
        (__ \ "name").write[String] and
        (__ \ "type").write[String] and
        (__ \ "inputmode").writeNullable[String] and
        (__ \ "describedBy").writeNullable[String] and
        (__ \ "value").writeNullable[String] and
        (__ \ "label").write[Label] and
        (__ \ "hint").writeNullable[Hint] and
        (__ \ "errorMessage").writeNullable[ErrorMessage] and
        writesFormGroupClasses and
        (__ \ "classes").write[String] and
        (__ \ "autocomplete").writeNullable[String] and
        (__ \ "pattern").writeNullable[String] and
        (__ \ "attributes").write[Map[String, String]] and
        (__ \ "spellcheck").writeNullable[Boolean] and
        (__ \ "prefix").writeNullable[PrefixOrSuffix] and
        (__ \ "suffix").writeNullable[PrefixOrSuffix]
    )(unlift(Input.unapply))

}
