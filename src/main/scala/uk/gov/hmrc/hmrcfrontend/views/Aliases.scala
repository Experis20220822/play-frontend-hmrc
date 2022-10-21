/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.hmrcfrontend.views

trait Aliases {
  type AccountHome = viewmodels.accountmenu.AccountHome
  val AccountHome = viewmodels.accountmenu.AccountHome

  type AccountMenu = viewmodels.accountmenu.AccountMenu
  val AccountMenu = viewmodels.accountmenu.AccountMenu

  type Banner = viewmodels.banner.Banner
  val Banner = viewmodels.banner.Banner

  type CheckProgress = viewmodels.accountmenu.CheckProgress
  val CheckProgress = viewmodels.accountmenu.CheckProgress

  val Cy = viewmodels.language.Cy

  val En = viewmodels.language.En

  type Header = viewmodels.header.Header
  val Header = viewmodels.header.Header

  type Footer = viewmodels.footer.Footer
  val Footer = viewmodels.footer.Footer

  type FooterNavigation = viewmodels.footer.FooterNavigation
  val FooterNavigation = viewmodels.footer.FooterNavigation

  type Meta = viewmodels.footer.Meta
  val Meta = viewmodels.footer.Meta

  type FooterItem = viewmodels.footer.FooterItem
  val FooterItem = viewmodels.footer.FooterItem

  type InternalHeader = viewmodels.internalheader.InternalHeader
  val InternalHeader = viewmodels.internalheader.InternalHeader

  type Language = viewmodels.language.Language
  val Language = viewmodels.language.Language

  type LanguageSelect = viewmodels.language.LanguageSelect
  val LanguageSelect = viewmodels.language.LanguageSelect

  type LanguageToggle = viewmodels.language.LanguageToggle
  val LanguageToggle = viewmodels.language.LanguageToggle

  type AccountMessages = viewmodels.accountmenu.AccountMessages
  val AccountMessages = viewmodels.accountmenu.AccountMessages

  type NavigationItem = viewmodels.header.NavigationItem
  val NavigationItem = viewmodels.header.NavigationItem

  type NewTabLink = viewmodels.newtablink.NewTabLink
  val NewTabLink = viewmodels.newtablink.NewTabLink

  type NotificationBadge = viewmodels.notificationbadge.NotificationBadge
  val NotificationBadge = viewmodels.notificationbadge.NotificationBadge

  type PageHeading = viewmodels.pageheading.PageHeading
  val PageHeading = viewmodels.pageheading.PageHeading

  type PaperlessSettings = viewmodels.accountmenu.PaperlessSettings
  val PaperlessSettings = viewmodels.accountmenu.PaperlessSettings

  type PersonalDetails = viewmodels.accountmenu.PersonalDetails
  val PersonalDetails = viewmodels.accountmenu.PersonalDetails

  type SignOut = viewmodels.accountmenu.SignOut
  val SignOut = viewmodels.accountmenu.SignOut

  type TimeoutDialog = viewmodels.timeoutdialog.TimeoutDialog
  val TimeoutDialog = viewmodels.timeoutdialog.TimeoutDialog

  type ReportTechnicalIssue = viewmodels.reporttechnicalissue.ReportTechnicalIssue
  val ReportTechnicalIssue = viewmodels.reporttechnicalissue.ReportTechnicalIssue

  type CurrencyInput = viewmodels.currencyinput.CurrencyInput
  val CurrencyInput = viewmodels.currencyinput.CurrencyInput

  type UserResearchBanner = viewmodels.userresearchbanner.UserResearchBanner
  val UserResearchBanner = viewmodels.userresearchbanner.UserResearchBanner

  type CharacterCount = viewmodels.charactercount.CharacterCount
  val CharacterCount = viewmodels.charactercount.CharacterCount

  type AddToAList = viewmodels.addtoalist.AddToAList
  val AddToAList = viewmodels.addtoalist.AddToAList

  type Timeline = viewmodels.timeline.Timeline
  val Timeline = viewmodels.timeline.Timeline

  type Event = viewmodels.timeline.Event
  val Event = viewmodels.timeline.Event

  type ListWithActions = viewmodels.listwithactions.ListWithActions
  val ListWithActions = viewmodels.listwithactions.ListWithActions

  type ListWithActionsItem = viewmodels.listwithactions.ListWithActionsItem
  val ListWithActionsItem = viewmodels.listwithactions.ListWithActionsItem

  type ListWithActionsAction = viewmodels.listwithactions.ListWithActionsAction
  val ListWithActionsAction = viewmodels.listwithactions.ListWithActionsAction
}

object Aliases extends Aliases
