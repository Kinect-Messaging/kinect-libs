package com.kinectmessaging.libs.common

object ErrorConstants {
    const val NO_DATA_FOUND_MESSAGE = "No valid data found for the provided input(s): "
    const val HTTP_5XX_ERROR_MESSAGE =
        "System error while processing request. Check the error message for more details: "
    const val HTTP_4XX_ERROR_MESSAGE = "Error while processing request. Check the error message for more details: "
}

object LogConstants {
    const val SERVICE_START = "Service Started "
    const val SERVICE_END = "Service Completed "
    const val SERVICE_DEBUG = "Service Debug "
}

object Defaults {
    const val PAGE_NO = 0
    const val PAGE_SIZE = 20
    const val TRANSACTION_ID_HEADER = "X-Transaction-Id"
    const val REQUEST_TIMEOUT = 60
    const val TRANSACTION_ID_MDC_KEY = "transactionId"
}

object CloudEventsHeaders {
    const val ID = "ce-id"
    const val SPEC_VERSION = "ce-specversion"
    const val TYPE = "ce-type"
    const val SOURCE = "ce-source"
    const val TIME = "ce-time"
    const val SUBJECT = "ce-subject"
}