package com.kinectmessaging.libs.logging

import com.kinectmessaging.libs.common.Defaults.TRANSACTION_ID_HEADER
import com.kinectmessaging.libs.common.Defaults.TRANSACTION_ID_MDC_KEY
import jakarta.ws.rs.client.ClientRequestContext
import jakarta.ws.rs.client.ClientRequestFilter
import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.container.ContainerResponseContext
import jakarta.ws.rs.ext.Provider
import org.jboss.logging.MDC
import org.jboss.resteasy.reactive.server.ServerRequestFilter
import org.jboss.resteasy.reactive.server.ServerResponseFilter
import java.util.*

class ServerRequestFilters {
    @ServerRequestFilter
    fun getRequestFilter(requestContext: ContainerRequestContext) {
        val requestId = requestContext.getHeaderString(TRANSACTION_ID_HEADER)
        MDC.put(TRANSACTION_ID_MDC_KEY, requestId ?: UUID.randomUUID().toString())
    }

    @ServerResponseFilter
    fun getResponseFilter(responseContext: ContainerResponseContext) {
//        MDC.remove(TRANSACTION_ID_MDC_KEY)
        MDC.clear()
    }
}

@Provider
class ClientRequestFilters : ClientRequestFilter {
    override fun filter(requestContext: ClientRequestContext) {
        val transactionId = MDC.get(TRANSACTION_ID_MDC_KEY)
        if (transactionId != null) {
            requestContext.headers[TRANSACTION_ID_HEADER] = listOf(transactionId)
        }
    }
}

