package com.kinectmessaging.libs.model


import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class KContactHistory(
    val id: String,
    val sourceEventId: String,
    val journeyTransactionId: String,
    val journeyName: String,
    val messages: ContactMessages,
)

@Serializable
data class ContactMessages (
    val messageId: String,
    var deliveryTrackingId: String?,
    val deliveryChannel: DeliveryChannel,
    var contactAddress: String,
    var deliveryStatus: List<DeliveryStatus>,
    var engagementStatus: List<EngagementStatus>?
)

@Serializable
data class EngagementStatus (
    @Serializable(with = LocalDateSerializer::class) val engagementTime: LocalDateTime,
    val engagementType: String,
    val engagementContext: String?
)

@Serializable
data class DeliveryStatus (
    @Serializable(with = LocalDateSerializer::class) val statusTime: LocalDateTime,
    val status: HistoryStatusCodes,
    val statusMessage: String?,
    val originalStatus: String?
)

@Serializable
enum class HistoryStatusCodes{
    CREATED,
    SENT,
    DELIVERED,
    FAILED,
}