package com.kinectmessaging.libs.common

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {
    @JvmStatic
    fun toIsoLocalDateTimeFormat(date: Date): String{
        val df = SimpleDateFormat(DateTimeFormatter.ISO_LOCAL_DATE_TIME.toString())
        return df.format(date)
    }

    @JvmStatic
    fun toIsoDateTimeFormat(date: Date): String{
        val pattern = "yyyy-MM-dd HH:mm:ss"
        val df = SimpleDateFormat(pattern)
        return df.format(date)
    }
}