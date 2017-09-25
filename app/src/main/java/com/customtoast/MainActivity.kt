package com.customtoast

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*








class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rnd = Random()


        btn_org.setOnClickListener {

            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            _Toast.bottomToastSuccess(this,R.mipmap.avatar,color,"#"+color+" Color with icon")


        }
        btn_green.setOnClickListener {
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            if(isNetworkConnected()){
                _Toast.bottomToastSuccess(this, R.mipmap.ic_connected, color, "Wi-fi Connected")

            }else {

                _Toast.bottomToastSuccess(this, R.mipmap.ic_launcher, color, "#" + color + " Color with icon")
            }

        }
        btn_white.setOnClickListener {
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

            _Toast.bottomToastSuccess(this,R.mipmap.ic_empty,color,"#"+color+" Color with icon")

        }

    }

    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting


        return isConnected
    }
}
