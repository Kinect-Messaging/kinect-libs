package com.kinectmessaging.libs.common

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern

const val STRING_LENGTH = 10
val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

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

object EmailUtils {
    @JvmStatic
    fun isEmailValid(email: String?): Boolean =
        email?.isNotBlank() == true && Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
                    ")+"
        ).matcher(email).matches()
}

object StringUtils {
    @JvmStatic
    fun randomAlphaNumeric() = List(STRING_LENGTH) { charPool.random() }.joinToString("")
}