package io.yard.api.slack

import play.api.libs.ws.WSRequestHolder
import play.api.libs.ws.ning.NingWSClient
import play.api.libs.json.Json

import io.yard.api.slack.models._

trait Response {
  def ok: Boolean
}

trait Ok[T] extends Response {
  def ok: Boolean = true
  def value: T
}

trait Error extends Response {
  def ok: Boolean = false
}

object SlackApi {
  val url = "https://slack.com/api/"
  val builder = new (com.ning.http.client.AsyncHttpClientConfig.Builder)()

  def http(url: String): WSRequestHolder = new NingWSClient(builder.build()).url(url)
  def request(method: String): WSRequestHolder = http(url + method)

  def send(team: String, token: String, incoming: IncomingWebHook) = {
    val url = s"https://${team.toLowerCase}.slack.com/services/hooks/incoming-webhook?token=${token}"
    http(url).post(Json.stringify(Json.toJson(incoming)))
  }
}
