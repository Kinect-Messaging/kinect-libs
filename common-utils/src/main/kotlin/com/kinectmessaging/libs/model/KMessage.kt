package com.kinectmessaging.libs.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeBodyPart

data class KMessage(
    val id: String,
    val sourceId: String,
    val deliveryChannel: DeliveryChannel,
    val targetSystem: TargetSystem,
    val emailData: EmailData?,
    )

@JsonIgnoreProperties(ignoreUnknown = true)
data class EmailData (
    val emailHeaders: Map<String, String>? = null,
    val textTemplateId: String,
    val htmlTemplateId: String,
    val senderAddress: String,
    val subject: String,
    val toRecipients: List<InternetAddress>,
    val ccRecipients: List<InternetAddress>? = null,
    val bccRecipients: List<InternetAddress>? = null,
    val attachments: List<Attachment>? = null,
    val replyTo: List<InternetAddress>? = null,
    val personalizationData: Map<String, Map<String, String?>?>? = null,
)

// TODO - Add SMS Delivery model
data class SmsData(
    val senderAddress: String,
)

data class Attachment (
    val name: String,
    val contentType: String,
    val content: MimeBodyPart
)




