package com.fahrizal.mvvmcompose.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {

    fun getDateFormatted(date: Date): String =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)

    fun getTimestamp(format: String, dateString: String?): Long {
        val date = SimpleDateFormat(format).parse(dateString) ?: Date(0)
        return date.time
    }

    @SuppressLint("SimpleDateFormat")
    fun getTimestamp(format: String, dateString: String, plusDay: Int): Long {
        val c = Calendar.getInstance()
        c.time = SimpleDateFormat(format).parse(dateString) ?: Date(0)
        c.add(Calendar.DATE, plusDay)
        return c.time.time
    }
}