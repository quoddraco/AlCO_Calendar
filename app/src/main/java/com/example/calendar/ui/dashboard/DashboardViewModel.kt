package com.example.calendar.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import android.util.Log



class DashboardViewModel : ViewModel() {
    val map: Map<Int, String> = mapOf(0 to "январь", 1 to "февраль", 2 to "март",
    3 to "апрель", 4 to "май", 5 to "июнь", 6 to "июль", 7 to "август", 8 to "сентябрь", 9 to "октябрь",
    10 to "ноябрь", 11 to "декабрь")


    val calendar = Calendar.getInstance()
    val currentMonth = calendar.get(Calendar.MONTH)

    val Month: String? = map[currentMonth]

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment!!!"
    }
    val text: LiveData<String> = _text

    private val textMonth = MutableLiveData<String>().apply {
        value = Month
    }
    val text2: LiveData<String> = textMonth
}