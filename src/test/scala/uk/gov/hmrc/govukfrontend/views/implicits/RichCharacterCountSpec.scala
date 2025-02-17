/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.govukfrontend.views.implicits

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import uk.gov.hmrc.govukfrontend.views.html.components.implicits._
import uk.gov.hmrc.govukfrontend.views.viewmodels.charactercount.CharacterCount
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.{HtmlContent, Text}
import uk.gov.hmrc.govukfrontend.views.viewmodels.errormessage.ErrorMessage
import uk.gov.hmrc.govukfrontend.views.viewmodels.errormessage.ErrorMessage.errorMessageWithDefaultStringsTranslated
import uk.gov.hmrc.govukfrontend.views.viewmodels.label.Label
import uk.gov.hmrc.helpers.MessagesHelpers
import uk.gov.hmrc.hmrcfrontend.views.config.{HmrcPageHeadingLabel, HmrcSectionCaption}

class RichCharacterCountSpec extends AnyWordSpec with Matchers with MessagesHelpers with RichFormInputHelpers {

  "Given an CharacterCount object, calling withFormField" should {
    "use the Field name as the CharacterCount name if no CharacterCount name provided" in {
      val characterCount = CharacterCount().withFormField(field)
      characterCount.name shouldBe "user-name"
    }

    "use the CharacterCount name over the Field name if both exist" in {
      val characterCount = CharacterCount(name = "CharacterCount Name").withFormField(field)
      characterCount.name shouldBe "CharacterCount Name"
    }

    "use the Field name as the id if no CharacterCount id provided" in {
      val characterCount = CharacterCount().withFormField(field)
      characterCount.id shouldBe "user-name"
    }

    "use the CharacterCount id over the Field name if both exist" in {
      val characterCount = CharacterCount(id = "CharacterCount Id").withFormField(field)
      characterCount.id shouldBe "CharacterCount Id"
    }

    "convert the first Field form error to a CharacterCount text error message if provided" in {
      val characterCount = CharacterCount().withFormField(field)
      characterCount.errorMessage shouldBe Some(
        errorMessageWithDefaultStringsTranslated(content = Text("Error on: Firstname&nbsp;Lastname"))
      )
    }

    "use the CharacterCount error message over the Field error if both provided" in {
      val characterCount = CharacterCount(
        errorMessage = Some(ErrorMessage(content = Text("Radios Error")))
      ).withFormField(field)
      characterCount.errorMessage shouldBe Some(ErrorMessage(content = Text("Radios Error")))
    }

    "use the Field value as the value if no CharacterCount id provided" in {
      val characterCount = CharacterCount().withFormField(field)
      characterCount.value shouldBe Some("bad")
    }

    "use the CharacterCount value over the Field value if both exist" in {
      val characterCount = CharacterCount(value = Some("CharacterCount Value")).withFormField(field)
      characterCount.value shouldBe Some("CharacterCount Value")
    }

    "correctly chain multiple Field properties provided to update an CharacterCount" in {
      val characterCount = CharacterCount()
      characterCount.withFormField(field) shouldBe CharacterCount(
        name = "user-name",
        id = "user-name",
        errorMessage =
          Some(errorMessageWithDefaultStringsTranslated(content = Text("Error on: Firstname&nbsp;Lastname"))),
        value = Some("bad")
      )
    }
  }

  "Given a CharacterCount object, calling withFormFieldWithErrorAsHtml" should {
    "convert the first Field form error to a CharacterCount HTML error message if provided" in {
      val characterCount = CharacterCount().withFormFieldWithErrorAsHtml(field = field)
      characterCount.errorMessage shouldBe Some(
        errorMessageWithDefaultStringsTranslated(content = HtmlContent("Error on: Firstname&nbsp;Lastname"))
      )
    }

    "use the CharacterCount error message over the Field error if both provided" in {
      val characterCount = CharacterCount(
        errorMessage = Some(ErrorMessage(content = Text("CharacterCount Error")))
      ).withFormFieldWithErrorAsHtml(field)
      characterCount.errorMessage shouldBe Some(ErrorMessage(content = Text("CharacterCount Error")))
    }
  }

  "Given a CharacterCount object, calling withHeading" should {
    "set the label to the passed in content" in {
      val characterCount = CharacterCount().withHeading(heading = Text("This is a text heading"))
      characterCount shouldBe CharacterCount(
        label = HmrcPageHeadingLabel(content = Text("This is a text heading"))
      )
    }

    "set the label to the passed in content, overriding any previously set content" in {
      val characterCountWithLabel = CharacterCount(
        label = Label(content = Text("This is some original text heading"))
      )
      val updatedCharacterCount   =
        characterCountWithLabel.withHeading(heading = Text("This is some updated text heading"))
      updatedCharacterCount shouldBe CharacterCount(
        label = HmrcPageHeadingLabel(content = Text("This is some updated text heading"))
      )
    }
  }

  "Given a CharacterCount object, calling withHeadingAndSectionCaption" should {
    "set the label and caption to the passed in content" in {
      val characterCount = CharacterCount().withHeadingAndSectionCaption(
        heading = Text("This is a text heading"),
        sectionCaption = Text("This is a text caption")
      )
      characterCount shouldBe CharacterCount(
        label = HmrcPageHeadingLabel(
          content = Text("This is a text heading"),
          caption = HmrcSectionCaption(Text("This is a text caption"))
        )
      )
    }

    "set the label to the passed in content, overriding any previously set content" in {
      val characterCountWithLabel = CharacterCount(
        label = Label(content = Text("This is some original text heading"))
      )
      val updatedCharacterCount   = characterCountWithLabel.withHeadingAndSectionCaption(
        heading = Text("This is some updated text heading"),
        sectionCaption = Text("This is a text caption")
      )
      updatedCharacterCount shouldBe CharacterCount(
        label = HmrcPageHeadingLabel(
          content = Text("This is some updated text heading"),
          caption = HmrcSectionCaption(Text("This is a text caption"))
        )
      )
    }
  }
}
