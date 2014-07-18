package io.yard.api.slack
package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Command(
  token: String,
  team_id: String,
  channel_id: String,
  channel_name: String,
  user_id: String,
  user_name: String,
  command: String,
  text: String
)

object Command {
  implicit val commandFormat = Json.format[Command]
}
