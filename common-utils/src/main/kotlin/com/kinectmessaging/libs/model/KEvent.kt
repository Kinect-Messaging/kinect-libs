package com.kinectmessaging.libs.model

import com.fasterxml.jackson.databind.JsonNode
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import java.time.LocalDateTime

@Serializable
data class KEvent(
    val eventId: String,
    val eventName: String,
    val eventTime: @Serializable(with = LocalDateSerializer::class) LocalDateTime,
    val payload: @Serializable(with = JsonNodeSerializer::class) JsonNode?,
    val recipients: List<Person>?
)



