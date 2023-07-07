package com.example.calendar.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class DashboardViewModel : ViewModel() {
    private var clickCount = 0


    private val map: Map<Int, String> = mapOf(
        0 to "январь", 1 to "февраль", 2 to "март",
        3 to "апрель", 4 to "май", 5 to "июнь", 6 to "июль", 7 to "август", 8 to "сентябрь",
        9 to "октябрь", 10 to "ноябрь", 11 to "декабрь"
    )

    private val calendar = Calendar.getInstance()
    private val currentMonth = calendar.get(Calendar.MONTH)


    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val _textMonth = MutableLiveData<String>()
    val text2: LiveData<String> = _textMonth

    init {
        _text.value = "Нажатий: $clickCount"
        _textMonth.value = map[currentMonth + clickCount]
    }

    fun incrementClickCountPlus() {

        clickCount++
        _text.value = "Нажатий: $clickCount"
        _textMonth.value = map[currentMonth + clickCount]
    }
    fun incrementClickCountMin() {
        clickCount--
        _text.value = "Нажатий: $clickCount"
        _textMonth.value = map[currentMonth + clickCount]
    }
}
