/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.supportfrontend.views

import play.api.templates.PlayMagic.toHtmlArgs
import play.twirl.api.Html
import uk.gov.hmrc.hmrcfrontend.views.Implicits.RichHtml

import java.net.URLEncoder

trait UtilsSupport {

  /**
    * Creates a space-separated list of CSS classes to be included in a template.
    *
    * @param firstClass
    * @param rest
    * @return
    */
  def toClasses(firstClass: String, rest: String*): String =
    rest.foldLeft(firstClass)((acc, curr) => if (curr.isEmpty) acc else s"$acc $curr")

  /**
    * Creates an HTML fragment with pairs of attribute=value.
    * The attributes HTML fragment is padded on the left with 1 space by default so when it is used in a template
    * it is nicely separated from the previous element.
    *
    * @param attributes
    * @param padCount
    * @return [[Html]]
    */
  def toAttributes(attributes: Map[String, String], padCount: Int = 1): Html = {
    val htmlArgs = toHtmlArgs(attributes.map { case (k, v) => Symbol(k) -> v })
    htmlArgs.padLeft(if (attributes.nonEmpty) padCount else 0)
  }

  object NonEmptyString {
    def unapply(s: String): Option[String] =
      if (s != null && s.nonEmpty) Some(s) else None
  }

  def urlEncode(s: String): String =
    URLEncoder.encode(s, "UTF-8").replace("+", "%20")

}
