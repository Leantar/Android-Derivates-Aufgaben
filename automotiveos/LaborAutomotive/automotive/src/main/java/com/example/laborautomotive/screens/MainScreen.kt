package com.example.laborautomotive.services

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import com.example.laborautomotive.screens.RequestPermissionScreen
import com.example.laborautomotive.screens.SpeedScreen

class MainScreen(carContext: CarContext) : Screen(carContext) {



    override fun onGetTemplate(): Template {
        val listBuilder = ItemList.Builder()
        listBuilder.addItem(
            Row.Builder()
                .setTitle("Grant Permissions")
                .setOnClickListener {
                    screenManager
                        .push(
                            RequestPermissionScreen(
                                 carContext
                            )
                        )
                }
                .build())
        listBuilder.addItem(
            Row.Builder()
                .setTitle("Show Current Speed")
                .setOnClickListener {
                    screenManager
                        .push(
                            SpeedScreen(
                                carContext,
                            )
                        )
                }
                .setBrowsable(true)
                .build())

        return ListTemplate.Builder()
            .setSingleList(listBuilder.build())
            .setTitle("Labor MobEng Car Info App")
            .setHeaderAction(Action.APP_ICON)
            .build()
    }



}