package com.kinectmessaging.libs.exception

data class ErrorMessage(
    val message: String?,
    val statusCode: Int?,
    val errors: Map<String, String>?
)
