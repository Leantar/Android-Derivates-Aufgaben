package com.example.android.wearable.wearos_aufgabe.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.example.android.wearable.wearos_aufgabe.viewmodels.SharedViewModel

@Composable
fun StepperScreen(
    viewModel: SharedViewModel
) {
    val amount by remember { viewModel.getAmount() }

    //TODO Implement the Stepper
    Stepper(
        value = amount,
        onValueChange = {
            viewModel.setAmount(it)
        },
        valueProgression = 50..2000 step 50,
        increaseIcon = { Icon(StepperDefaults.Increase, "Increase") },
        decreaseIcon = { Icon(StepperDefaults.Decrease, "Decrease") },
        modifier = Modifier.fillMaxSize()
            .padding(top = 10.dp),
    ) {
        Text("Value: $amount")
    }
}