/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views.viewmodels.dateinput

import play.api.libs.functional.syntax._
import play.api.libs.json._
import uk.gov.hmrc.govukfrontend.views.html.components._
import uk.gov.hmrc.govukfrontend.views.viewmodels.CommonJsonFormats._

case class DateInput(
  id: String = "",
  namePrefix: Option[String] = None,
  items: Seq[InputItem] = Seq.empty,
  hint: Option[Hint] = None,
  errorMessage: Option[ErrorMessage] = None,
  formGroupClasses: String = "",
  fieldset: Option[Fieldset] = None,
  classes: String = "",
  attributes: Map[String, String] = Map.empty
)

object DateInput {

  def defaultObject: DateInput = DateInput()

  implicit def jsonReads: Reads[DateInput] =
    (
      (__ \ "id").readWithDefault[String](defaultObject.id) and
        (__ \ "namePrefix").readNullable[String] and
        (__ \ "items").readWithDefault[Seq[InputItem]](defaultObject.items) and
        (__ \ "hint").readNullable[Hint] and
        (__ \ "errorMessage").readNullable[ErrorMessage] and
        readsFormGroupClasses and
        (__ \ "fieldset").readNullable[Fieldset] and
        (__ \ "classes").readWithDefault[String](defaultObject.classes) and
        (__ \ "attributes").readWithDefault[Map[String, String]](defaultObject.attributes)
    )(DateInput.apply _)

  implicit def jsonWrites: OWrites[DateInput] =
    (
      (__ \ "id").write[String] and
        (__ \ "namePrefix").writeNullable[String] and
        (__ \ "items").write[Seq[InputItem]] and
        (__ \ "hint").writeNullable[Hint] and
        (__ \ "errorMessage").writeNullable[ErrorMessage] and
        writesFormGroupClasses and
        (__ \ "fieldset").writeNullable[Fieldset] and
        (__ \ "classes").write[String] and
        (__ \ "attributes").write[Map[String, String]]
    )(unlift(DateInput.unapply))

}
