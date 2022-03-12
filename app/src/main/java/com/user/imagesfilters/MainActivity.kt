package com.user.imagesfilters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.user.imagefilter.ImageFilterMessage
import com.user.imagefilter.PermissionUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       ImageFilterMessage.showToast(this,"Hello world")



    }
}