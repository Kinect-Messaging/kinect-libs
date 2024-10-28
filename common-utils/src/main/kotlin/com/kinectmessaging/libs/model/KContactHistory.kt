package com.kinectmessaging.libs.model

import java.time.LocalDateTime

data class KContactHistory(
    val id: String,
    val sourceEventId: String,
    val journeyTransactionId: String,
    val journeyName: String,
    val messages: ContactMessages,
)

data class ContactMessages (
    val messageId: String,
    var deliveryTrackingId: String?,
    val deliveryChannel: DeliveryChannel,
    var contactAddress: String,
    var deliveryStatus: List<DeliveryStatus>,
    var engagementStatus: List<EngagementStatus>?
)

data class EngagementStatus (
    val engagementTime: LocalDateTime,
    val engagementType: String,
    val engagementContext: String?
)

data class DeliveryStatus (
    val statusTime: LocalDateTime,
    val status: HistoryStatusCodes,
    val statusMessage: String?,
    val originalStatus: String?
)

enum class HistoryStatusCodes{
    CREATED,
    SENT,
    DELIVERED,
    FAILED,
}