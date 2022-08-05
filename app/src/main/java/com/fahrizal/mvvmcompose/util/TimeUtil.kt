package com.fahrizal.mvvmcompose.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {

    fun getDateFormatted(date: Date, format: String = "yyyy-MM-dd"): String =
        SimpleDateFormat(format, Locale.getDefault()).format(date)

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

    fun Long.getTimeFormated(): String =
        SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date(this))

    fun getLocaleFormat(date: Date) :String{
        return SimpleDateFormat.getDateInstance().format(date)
    }
}