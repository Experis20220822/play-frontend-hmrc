/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.govukfrontend.views

import uk.gov.hmrc.supportfrontend.views.UtilsSupport

trait Utils extends UtilsSupport {

  private[views] def isNonEmptyOptionString(value: Option[String]): Boolean = value match {
    case Some(NonEmptyString(_)) => true
    case _                       => false
  }

  private[views] def calculateAssetPath(path: Option[String], file: String): String =
    path
      .map(p => s"$p/$file")
      .getOrElse(uk.gov.hmrc.hmrcfrontend.controllers.routes.Assets.at(s"govuk/$file").url)

}

object Utils extends Utils
