package com.example.laborautomotive.screens

import android.content.pm.PackageManager
import androidx.car.app.CarAppPermission
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.*

class RequestPermissionScreen(carContext: CarContext):Screen(carContext)
{
    private val mPreSeedMode = false
    private val mRefreshAction = Action.Builder()
        .setTitle("Refresh")
        .setBackgroundColor(CarColor.BLUE)
        .setOnClickListener { invalidate() }
        .build()

    init{

    }
    override fun onGetTemplate(): Template {
        val headerAction = if (mPreSeedMode) Action.APP_ICON else Action.BACK
        val permissions: MutableList<String> = ArrayList()
        val declaredPermissions: Array<String>
        declaredPermissions = try {
            val info = carContext.packageManager.getPackageInfo(
                carContext.packageName,
                PackageManager.GET_PERMISSIONS
            )
            info.requestedPermissions
        } catch (e: PackageManager.NameNotFoundException) {
            return MessageTemplate.Builder("Package Not found.")
                .setHeaderAction(headerAction)
                .addAction(mRefreshAction)
                .build()
        }
        if (declaredPermissions != null) {
            for (declaredPermission in declaredPermissions) {
                if (declaredPermission.startsWith("androidx.car.app")) {
                    continue
                }
                try {
                    CarAppPermission.checkHasPermission(carContext, declaredPermission)
                } catch (e: SecurityException) {
                    permissions.add(declaredPermission)
                }
            }
        }
        if (permissions.isEmpty()) {
            return MessageTemplate.Builder(
                "All permissions have been granted. Please "
                        + "revoke permissions from Settings."
            )
                .setHeaderAction(headerAction)
                .addAction(
                    Action.Builder()
                        .setTitle("Close")
                        .setOnClickListener { finish() }
                        .build())
                .build()
        }
        val message = StringBuilder()
            .append("The app needs access to the following permissions:\n")
        for (permission in permissions) {
            message.append(permission)
            message.append("\n")
        }
        val listener: OnClickListener = ParkedOnlyOnClickListener.create {
            carContext.requestPermissions(
                permissions
            ) { approved: List<String?>?, rejected: List<String?>? ->
                CarToast.makeText(
                    carContext,
                    String.format("Approved: %s Rejected: %s", approved, rejected),
                    CarToast.LENGTH_LONG
                ).show()
            }
            if (!carContext.packageManager
                    .hasSystemFeature(PackageManager.FEATURE_AUTOMOTIVE)
            ) {
                CarToast.makeText(
                    carContext, "Grant Permission on the phone screen",
                    CarToast.LENGTH_LONG
                ).show()
            }
        }
        val action = Action.Builder()
            .setTitle("Grant Access")
            .setBackgroundColor(CarColor.BLUE)
            .setOnClickListener(listener)
            .build()

        val builder = LongMessageTemplate.Builder(message)
            .setTitle("Required Permissions")
            .addAction(action)
            .setHeaderAction(headerAction)
        return builder.build()
    }
}
