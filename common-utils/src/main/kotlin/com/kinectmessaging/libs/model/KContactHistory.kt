package com.kinectmessaging.libs.model

import java.util.*
import kotlin.collections.List

data class KContactHistory(
    val id: String,
    val journeyTransactionId: String,
    val journeyName: String,
    val messages: ContactMessages,
)

data class ContactMessages (
    val messageId: String,
    val deliveryTrackingId: String?,
    val deliveryChannel: DeliveryChannel,
    val contactAddress: String,
    val deliveryStatus: List<DeliveryStatus>,
    val engagementStatus: List<EngagementStatus>?
)

data class EngagementStatus (
    val engagementTime: Date,
    val engagementType: String,
    val engagementContext: String?
)

data class DeliveryStatus (
    val statusTime: Date,
    val status: String,
    val statusMessage: String?,
    val originalStatus: String?
)