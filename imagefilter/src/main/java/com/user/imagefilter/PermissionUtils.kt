package com.user.imagefilter

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionUtils {


    companion object {
        var Location = 3;

        fun ShowSingleButtonDialog(
            activity: Context?,
            title: String?,
            message: String?,
            buttontext: String?
        ) {
            val alert = AlertDialog.Builder(
                activity!!
            )
            alert.setMessage(message)
            alert.setTitle(title)
            alert.setPositiveButton(
                buttontext
            ) { dialog, which -> // TODO Auto-generated method stub
                dialog.dismiss()
            }
            alert.create()
            alert.show()
        }


        fun locationPermission(activity: Activity?) {
            val netPermission =
                ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            if (netPermission != PackageManager.PERMISSION_GRANTED) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(
                        activity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                ) {
                    ActivityCompat.requestPermissions(
                        activity,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        Location
                    )
                    return
                }
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    Location
                )
                return
            }
        }

        fun locationInitialCheck(activity: Activity?): Boolean {
            val netPermission =
                ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            return netPermission != PackageManager.PERMISSION_GRANTED
        }


/*
        fun checkingAllPermissions(activity: Activity?): Boolean {
            val status = false
            val PERMISSION_ALL = 1
            val PERMISSIONS = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
            )
            return if (!hasPermissions(activity, *PERMISSIONS)) {
                ActivityCompat.requestPermissions(activity!!, PERMISSIONS, PERMISSION_ALL)
                false
            } else {
                true
            }
        }
*/

        fun checkingAllPermissions(activity: Activity?, PERMISSIONS: Array<String>?): Boolean {
            val status = false
            val PERMISSION_ALL = 1
            //        String[] PERMISSIONS = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA};
            return if (!hasPermissions(activity, PERMISSIONS.toString())) {
                ActivityCompat.requestPermissions(activity!!, PERMISSIONS!!, PERMISSION_ALL)
                false
            } else {
                true
            }
        }


        fun checkLocation(activity: Activity?): Boolean {
            val netPermission =
                ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            return netPermission == PackageManager.PERMISSION_GRANTED
        }

        fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
                for (permission in permissions) {
                    if (ActivityCompat.checkSelfPermission(
                            context,
                            permission!!
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        return false
                    }
                }
            }
            return true
        }

        fun requestPermissions(activity: Activity?): Boolean {
            val locationPermission: Boolean = checkLocation(activity)
            return if (!locationPermission /*&&!contactsPermission*/) {
                val PERMISSIONS = arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
                checkingAllPermissions(activity, PERMISSIONS)
                false
            } else {
                true
            }
        }

    }


}
