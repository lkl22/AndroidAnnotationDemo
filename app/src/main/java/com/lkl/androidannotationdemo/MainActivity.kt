package com.lkl.androidannotationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lkl.androidannotationdemo.meta.RetentionPolicyAnnotationTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val t = RetentionPolicyAnnotationTest(1)
    }
}
