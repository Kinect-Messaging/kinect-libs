package com.kinectmessaging.libs.model

import org.apache.commons.lang3.RandomStringUtils
import javax.mail.internet.MimeBodyPart

data class JourneyConfig(
    val journeyId: String,
    val journeyName: String = "Unnamed_Journey_${RandomStringUtils.randomAlphanumeric(1,4)}",
    val journeySteps: List<JourneySteps>?,
    val auditInfo: Audit
)

data class JourneySteps (
    val seqId: Int,
    val eventName: String,
    val stepCondition: String?,
    val messageConfigs: Map<String, String>
)

data class MessageConfig(
    val messageId: String,
    val messageName: String = "Unnamed_Message_${RandomStringUtils.randomAlphanumeric(1,4)}",
    val messageVersion: Int = 1,
    val messageCondition: String?,
    val messageStatus: MessageStatus? = MessageStatus.DRAFT,
    val emailConfig: List<EmailConfig>?,
    val journeyId: String?,
    val auditInfo: Audit,
)

enum class MessageStatus {
    DRAFT,
    DEV,
    STAGE,
    PRODUCTION,
    INACTIVE,
    ARCHIVE
}

data class EmailConfig (
    val targetSystem: TargetSystem,
    val emailHeaders: Map<String, String>?,
    val senderAddress: String? = null,
    val subject: String,
    val toRecipients: List<EmailRecipientConfig>,
    val ccRecipients: List<EmailRecipientConfig>? = null,
    val bccRecipients: List<EmailRecipientConfig>? = null,
    val replyTo: List<EmailRecipientConfig>? = null,
    val attachments: List<AttachmentConfig>? = null,
    val personalizationData: Map<String, Map<String, String?>?>? = null,
    val templateConfig: Map<String, String>
)

data class EmailRecipientConfig (
    val firstName: String,
    val lastName: String,
    val emailAddress: String
)

data class AttachmentConfig (
    val name: String,
    val contentType: String,
    val content: String
)


data class EnvConfig(
    val envId: String,
    val envName: EnvNames,
    val journeyId: String,
    val messageId: String,
    val eventName: String,
    val changeLog: List<ChangeLog>
)


enum class EnvNames {
    DEV,
    STAGE,
    PROD
}
