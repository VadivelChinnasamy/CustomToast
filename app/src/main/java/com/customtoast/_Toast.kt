package com.customtoast

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

/**
 * Created by vadivel on 27/4/17.
 */

object _Toast {


    private var bgShape: GradientDrawable? = null


    fun centerToast(_context: Context, text: String) {
        val t = Toast.makeText(_context, text, Toast.LENGTH_SHORT)
        t.setGravity(Gravity.CENTER, 0, 0)
        t.show()
    }


    fun bottomToastSuccess(_context: Context, ic_user_name: Int,color: Int, msg: String) {
        val inflater = _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.toast, null)

        val image = layout.findViewById<View>(R.id.image) as ImageView
        val view = layout.findViewById<View>(R.id.toast_layout) as LinearLayout

        bgShape = view.background as GradientDrawable
        bgShape!!.setColor(color)

        image.setBackgroundResource(ic_user_name)
        image.backgroundTintList = ContextCompat.getColorStateList(_context, R.color.white)
        val text = layout.findViewById<View>(R.id.text) as TextView
        text.text = "" + msg

        val toast = Toast(_context)
        toast.duration = Toast.LENGTH_LONG
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.view = layout//setting the view of custom toast layout
        toast.show()


    }

}

