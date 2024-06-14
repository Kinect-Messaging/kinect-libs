package com.kinect.messaging.libs.common

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {
    @JvmStatic
    fun toIsoLocalDateTimeFormat(date: Date): String{
        val df = SimpleDateFormat(DateTimeFormatter.ISO_LOCAL_DATE_TIME.toString())
        return df.format(date)
    }
}