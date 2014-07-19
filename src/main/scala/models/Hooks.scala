package io.yard.api.slack
package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

// IncomingWebHook
case class IncomingWebHook(
  text: String,
  username: Option[String] = None,
  channel: Option[String] = None,
  icon_url: Option[String] = None,
  icon_emoji: Option[String] = None,
  attachments: Option[List[Attachment]] = None
)

object IncomingWebHook {
  implicit val incomingWebHookFormat = Json.format[IncomingWebHook]
}

// OutgoingWebHook
case class OutgoingWebHook(
  token: String,
  team_id: String,
  team_domain: String,
  channel_id: String,
  channel_name: String,
  timestamp: String,
  user_id: String,
  user_name: String,
  text: Option[String],
  service_id: Option[String],
  trigger_word: Option[String]
) {
  lazy val content: String = this.text.getOrElse("")
  lazy val acceptable: Boolean = (this.user_id != "USLACKBOT") && this.text.isDefined
}

object OutgoingWebHook {
  implicit val outgoingWebHookFormat = Json.format[OutgoingWebHook]
}
