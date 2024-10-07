package com.kinectmessaging.libs.model

import com.fasterxml.jackson.databind.JsonNode
import java.util.*

data class KEvent(
    val eventId: String,
    val eventName: String,
    val eventTime: Date,
    val payload: JsonNode?,
    val recipients: List<Person>?
)



