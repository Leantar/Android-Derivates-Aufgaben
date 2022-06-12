package com.example.android.wearable.wearos_aufgabe.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.android.wearable.wearos_aufgabe.data.WaterIntakeData
import java.time.LocalTime

class SharedViewModel: ViewModel() {
    private val waterIntakeData: MutableList<WaterIntakeData> = mutableListOf()
    private val amount: MutableState<Int> = mutableStateOf(50)
    private val time: MutableState<LocalTime> = mutableStateOf(LocalTime.now())

    fun getAllWaterIntakeData(): List<WaterIntakeData> {
        return waterIntakeData
    }

    fun addWaterIntakeData(data: WaterIntakeData) {
        waterIntakeData.add(data)
    }

    fun setAmount(a: Int) {
        amount.value = a
    }

    fun getAmount(): State<Int> = amount

    fun setTime(t: LocalTime) {
        time.value = t
    }

    fun getTime(): State<LocalTime> = time
}