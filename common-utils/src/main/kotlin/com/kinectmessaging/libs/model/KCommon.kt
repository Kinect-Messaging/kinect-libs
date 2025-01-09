package com.kinectmessaging.libs.model

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.mail.internet.InternetAddress
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class Audit(
    val createdBy: String,
    val createdTime: String,
    val updatedBy: String?,
    val updatedTime: String?
)

@Serializable
data class ChangeLog(
    val user: String,
    val time: String,
    val comment: String
)

@Serializable
data class Contact (
    val email: String?,
    val phone: String?,
    val address: Address?
)

@Serializable
data class Person(
    val firstName: String,
    val lastName: String?,
    val contacts: List<Contact>?,
    // Default preference is English. Priority is set to 1 as highest.
    val preferredLanguage: Map<Language, Int>? = mapOf(Pair(Language.EN, 1))
)

@Serializable
data class Address(
    val addressLine1: String,
    val addressLine2: String?,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
)

/**
 * ISO 639-1 code for language
 */
@Serializable
enum class Language {
    EN //English
    ,ES //Spanish
}

@Serializable
enum class DeliveryChannel {
    EMAIL, SMS
}

@Serializable
enum class TargetSystem {
    AZURE_COMMUNICATION_SERVICE, AWS_SIMPLE_EMAIL_SERVICE
}


@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = LocalDateTime::class)
class LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(value.format(formatter))
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.parse(decoder.decodeString(), formatter)
    }
}

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = OffsetDateTime::class)
class OffsetDateTimeSerializer : KSerializer<OffsetDateTime> {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    override fun serialize(encoder: Encoder, value: OffsetDateTime) {
        encoder.encodeString(value.format(formatter))
    }

    override fun deserialize(decoder: Decoder): OffsetDateTime {
        return OffsetDateTime.parse(decoder.decodeString(), formatter)
    }
}


class InternetAddressSerializer : KSerializer<InternetAddress> {

        override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("InternetAddress", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: InternetAddress) {
            encoder.encodeString(value.toString())
        }

        override fun deserialize(decoder: Decoder): InternetAddress {
            return InternetAddress(decoder.decodeString())
        }

}

class JsonNodeSerializer : KSerializer<JsonNode> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("JsonNode", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: JsonNode) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): JsonNode {
        val mapper = ObjectMapper()
        val factory: JsonFactory = mapper.factory
        val parser: JsonParser = factory.createParser(decoder.decodeString())
        return mapper.readTree(parser)
    }

}