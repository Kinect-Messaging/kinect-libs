package com.kinectmessaging.libs.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import java.time.LocalDateTime
import kotlinx.serialization.Serializable
import java.net.URI
import java.time.OffsetDateTime

//@JsonIgnoreProperties(ignoreUnknown = true)
//data class CloudEventsSchema(
//    @JsonProperty("specversion")
//    val specVersion: String,
//    val type: String,
//    val source: String,
//    val id: String,
//    val time: LocalDateTime,
//    @JsonProperty("datacontenttype")
//    val dataContentType: String = "application/json",
//    val data: JsonNode
//    )




@Serializable
data class CloudEventsSchema(
    val id: String,
    val source: @Contextual URI,
    val type: String,
    val time: @Serializable(with = OffsetDateTimeSerializer::class) OffsetDateTime? = null,
    @SerialName("datacontenttype")
    val dataContentType: String? = null,
    @SerialName("dataschema")
    val dataSchema: @Contextual URI? = null,
    val subject: String? = null,
    val data: String? = null,
    val extensions: Map<String, String>? = null
)