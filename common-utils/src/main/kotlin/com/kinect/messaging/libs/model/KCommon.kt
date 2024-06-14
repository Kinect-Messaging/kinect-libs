package com.kinect.messaging.libs.model

data class Audit(
    val createdBy: String,
    val createdTime: String,
    val updatedBy: String?,
    val updatedTime: String?
)

data class ChangeLog(
    val user: String,
    val time: String,
    val comment: String
)

data class Contact (
    val email: String?,
    val phone: String?,
    val address: Address?
)

data class Person(
    val firstName: String,
    val lastName: String?,
    val contacts: List<Contact>?,
    // Default preference is English. Priority is set to 1 as highest.
    val preferredLanguage: Map<TemplateLanguage, Int>? = mapOf(Pair(TemplateLanguage.EN, 1))
)

data class Address(
    val addressLine1: String,
    val addressLine2: String?,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
)

enum class DeliveryChannel {
    EMAIL, SMS
}

enum class TargetSystem {
    AZURE_COMMUNICATION_SERVICE, AWS_SIMPLE_EMAIL_SERVICE
}