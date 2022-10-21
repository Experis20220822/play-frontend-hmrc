/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views

import uk.gov.hmrc.supportfrontend.views.UtilsSupport

trait Utils extends UtilsSupport {

  private[views] def calculateAssetPath(path: Option[String], file: String): String =
    path
      .map(p => s"$p/$file")
      .getOrElse(uk.gov.hmrc.hmrcfrontend.controllers.routes.Assets.at(file).url)
}

object Utils extends Utils
