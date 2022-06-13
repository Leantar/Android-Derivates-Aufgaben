package com.example.laborautomotive.services

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session

class CarSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return MainScreen(carContext)
    }
}