/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend

import play.api.mvc.RequestHeader

package object config {
  private[config] def pathWithQuerystring(request: RequestHeader): String = {
    import request._
    s"$path${if (rawQueryString.nonEmpty) "?" else ""}$rawQueryString"
  }
}
