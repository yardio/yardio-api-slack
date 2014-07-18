package io.yard.api.slack
package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class AttachmentField(title: String, value: String, short: Boolean = false)

object AttachmentField {
  implicit val attachmentFieldFormat = Json.format[AttachmentField]
}

case class Attachment(
  fallback: String,
  text: Option[String] = None,
  pretext: Option[String] = None,
  color: Option[String] = None, // Hex code or 'good' or 'warning' or 'danger'
  fields: List[AttachmentField] = List())

object Attachment {
  implicit val attachmentFormat = Json.format[Attachment]
}
