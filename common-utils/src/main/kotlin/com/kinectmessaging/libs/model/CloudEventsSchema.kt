package com.kinectmessaging.libs.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class CloudEventsSchema(
    @JsonProperty("specversion")
    val specVersion: String,
    val type: String,
    val source: String,
    val id: String,
    val time: LocalDateTime,
    @JsonProperty("datacontenttype")
    val dataContentType: String = "application/json",
    val data: JsonNode
    )
