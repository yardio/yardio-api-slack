package io.yard.api.slack
package models

import play.api.libs.json._
import play.api.libs.functional.syntax._


case class Team(id: String, name: String, modules: Option[Seq[String]], tokens: Map[String, Seq[String]])

object Team {
  implicit val teamFormat = Json.format[Team]
}
