package com.kinectmessaging.libs.model

import com.fasterxml.jackson.databind.JsonNode
import java.time.LocalDateTime

data class KEvent(
    val eventId: String,
    val eventName: String,
    val eventTime: LocalDateTime,
    val payload: JsonNode?,
    val recipients: List<Person>?
)



