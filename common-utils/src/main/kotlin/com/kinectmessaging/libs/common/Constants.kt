package com.kinectmessaging.libs.common

object ErrorConstants {
    const val NO_DATA_FOUND_MESSAGE = "No valid data found for the provided input(s): "
    const val HTTP_5XX_ERROR_MESSAGE = "Error while processing request. Check the error message for more details: "
}

object LogConstants {
    const val SERVICE_START = "Service Started "
    const val SERVICE_END = "Service Completed "
    const val SERVICE_DEBUG = "Service Debug "
}

object Defaults{
    const val PAGE_NO = 0
    const val PAGE_SIZE = 20
    const val TRANSACTION_ID_HEADER = "X-Transaction-Id"
}