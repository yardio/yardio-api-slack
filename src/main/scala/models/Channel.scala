package io.yard.api.slack
package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Channel(id: String, name: Option[String])

object Channel {
  implicit val channelFormat = Json.format[Channel]
}
