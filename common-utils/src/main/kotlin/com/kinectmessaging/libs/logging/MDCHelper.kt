package com.kinectmessaging.libs.logging

import org.jboss.logging.MDC

object MDCHelper {
    fun addMDC(headers: Map<String, String?>) {
        headers.forEach { (key, value) ->
            if (key.isNotBlank() && value?.isNotBlank() == true){
                MDC.put(key, value)
            }
        }
    }

    fun clearMDC(){
        MDC.clear()
    }
}