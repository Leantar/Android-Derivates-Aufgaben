package com.example.android.wearable.wearos_aufgabe.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.android.wearable.wearos_aufgabe.data.WaterIntakeData
import java.time.LocalDateTime

class SharedViewModel: ViewModel() {
    private val waterIntakeData: MutableList<WaterIntakeData> = mutableListOf()
    /*private var amount = 50
    private var time = LocalDateTime.now()*/
    private val amount: MutableState<Int> = mutableStateOf(50)
    private val time: MutableState<LocalDateTime> = mutableStateOf(LocalDateTime.now())

    fun getAllWaterIntakeData(): List<WaterIntakeData> {
        return waterIntakeData
    }

    fun addWaterIntakeData(data: WaterIntakeData) {
        waterIntakeData.add(data)
    }

    fun setAmount(a: Int) {
        amount.value = a
    }

    fun getAmount(): MutableState<Int> = amount

    fun setTime(t: LocalDateTime) {
        time.value = t
    }

    fun getTime(): MutableState<LocalDateTime> = time



   /* fun setAmount(a: Int) {
        amount = a
    }

    fun getAmount(): Int = amount

    fun setTime(t: LocalDateTime) {
        time = t
    }

    fun getTime(): LocalDateTime = time*/
}