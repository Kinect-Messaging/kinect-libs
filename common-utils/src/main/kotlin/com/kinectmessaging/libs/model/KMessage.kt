package com.kinectmessaging.libs.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.serialization.Serializable

@Serializable
data class KMessage(
    val id: String,
    val sourceId: String,
    val deliveryChannel: DeliveryChannel,
    val targetSystem: TargetSystem,
    val emailData: EmailData?,
    )

@Serializable
@JsonIgnoreProperties(ignoreUnknown = true)
data class EmailData (
    val emailHeaders: Map<String, String>? = null,
    val textTemplateId: String,
    val htmlTemplateId: String,
    val senderAddress: String,
    val subject: String,
    val toRecipients: List<Person>,
    val ccRecipients: List<Person>? = null,
    val bccRecipients: List<Person>? = null,
    val attachments: List<Attachment>? = null,
    val replyTo: List<Person>? = null,
    val personalizationData: Map<String, Map<String, String?>?>? = null,
)

// TODO - Add SMS Delivery model
data class SmsData(
    val senderAddress: String,
)

@Serializable
data class Attachment (
    val name: String,
    val contentType: String,
    val content: String
)




