package com.fahrizal.mvvmcompose.util

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {

    fun getDateFormatted(date: Date): String =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)

    fun getTimestamp(format: String, dateString: String?): Long {
        val date = SimpleDateFormat(format).parse(dateString) ?: Date(0)
        return date.time
    }
}