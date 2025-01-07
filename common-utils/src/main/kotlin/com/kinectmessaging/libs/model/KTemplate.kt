package com.kinectmessaging.libs.model

import com.kinectmessaging.libs.model.TemplateType.CONTROL
import com.kinectmessaging.libs.model.TemplateType.TREATMENT
import kotlinx.serialization.Serializable

@Serializable
data class KTemplate(
    val templateId: String,
    val templateName: String,
    val templateType: TemplateType = CONTROL,
    val templateLanguage: Language = Language.EN,
    val templateContent: String,
    val auditInfo: Audit
)

@Serializable
data class TemplatePersonalizationRequest(
    val textTemplateId: String?,
    val htmlTemplateId: String?,
    val personalizationData: Map<String, Map<String, String?>?>?
)



/**
 * Template type to be selected for application
 * @property CONTROL - Represents control template for A/B testing. Use for default application.
 * Only one control template can be assigned.
 * @property TREATMENT - Represents treatment templates for A/B testing.
 * More than one treatment template can be assigned.
 */
@Serializable
enum class TemplateType {
    CONTROL, TREATMENT
}
