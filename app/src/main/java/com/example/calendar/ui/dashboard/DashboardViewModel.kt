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
    private var currentYear = calendar.get(Calendar.YEAR)

    private var clickCountMax = (11 - currentMonth) + 1
    private var clickCountMin = (-1 * currentMonth) - 1


    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val _textMonth = MutableLiveData<String>()
    val text2: LiveData<String> = _textMonth

    private val _textDay= MutableLiveData<Int>()
    val textDay: LiveData<Int> = _textDay

    init {
        _text.value = currentYear.toString()
        _textMonth.value = map[currentMonth + clickCount]
        _textDay.value = getLastDayOfMonth(currentMonth + clickCount)

    }

    fun incrementClickCountPlus() {
        clickCount++
        if (clickCount == clickCountMax){
            clickCount = (-1 * currentMonth)
            currentYear++
        }
        _text.value = currentYear.toString()
        _textMonth.value = map[currentMonth + clickCount]
        _textDay.value = getLastDayOfMonth(currentMonth + clickCount)
    }
    fun incrementClickCountMin() {
        clickCount--
        if (clickCount == clickCountMin){
            clickCount = (11 - currentMonth)
            currentYear--
        }
        _text.value = currentYear.toString()
        _textMonth.value = map[currentMonth + clickCount]
        _textDay.value = getLastDayOfMonth(currentMonth + clickCount)
    }

    fun getLastDayOfMonth(month: Int): Int {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, month)
        val lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        return lastDay
    }




}
