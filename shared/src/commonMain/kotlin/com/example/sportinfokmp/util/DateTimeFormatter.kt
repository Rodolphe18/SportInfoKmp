package com.example.sportinfokmp.util


import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.LocalDateTime

object DateTimeFormatter {

    fun getFormattedDate(value:String):String? {
       return try {
            val offSet = LocalDateTime.parse(value)
            val dayOfWeek = offSet.dayOfWeek.name.lowercase().capitalize(Locale.current)
            val month = offSet.month.name.lowercase()
            val dayOfMonth = offSet.dayOfMonth
            val formattedDate = "$dayOfWeek $dayOfMonth $month "
            formattedDate
        } catch(e:Exception) {
            null
        }
    }

    fun getFormattedTime(value:String):String {
        val offSet = LocalDateTime.parse(value)
        val time = "${offSet.hour}h${if (offSet.minute != 0) offSet.minute else "00"}"
        return time
    }

}