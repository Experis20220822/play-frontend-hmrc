/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.controllers

import controllers.{AssetsBuilder, AssetsMetadata}
import javax.inject.{Inject, Singleton}
import play.api.http.HttpErrorHandler

/*
 * Without this we get
 * [RuntimeException: java.lang.NoSuchMethodError: controllers.ReverseAssets.versioned(Ljava/lang/String;)Lplay/api/mvc/Call;]
 * when using Assets.
 */
@Singleton
class Assets @Inject() (errorHandler: HttpErrorHandler, meta: AssetsMetadata) extends AssetsBuilder(errorHandler, meta)
