package ru.dogshoke.myapplication

import android.os.Bundle
import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var button = findViewById<Button>(R.id.MyButton)
        var linearLayout = findViewById<LinearLayout>(R.id.LL)
        var stateColor = "Orange"

        button.setOnClickListener {
            if (stateColor == "Orange") {
                stateColor = "Blue"
                linearLayout.background = AppCompatResources.getDrawable(this, R.color.blue)
            } else {
                stateColor = "Orange"
                linearLayout.background = AppCompatResources.getDrawable(this, R.color.orange)
            }
        }
        var linearLayoutText = findViewById<LinearLayout>(R.id.LLtext)
        var stateColorText = "Green"
        var textView = findViewById<TextView>(R.id.Tv)
        textView.setOnLongClickListener {
            if (stateColorText == "Green") {
                stateColorText = "White"
                linearLayoutText.background = AppCompatResources.getDrawable(this, R.color.white)
            } else {
                stateColorText = "Green"
                linearLayoutText.background = AppCompatResources.getDrawable(this, R.color.green)
            }
            true
        }

        var tv = findViewById<TextView>(R.id.Tv)
        var edittext = findViewById<EditText>(R.id.ET)
        edittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (edittext.text.toString() == "samsung") {
                    tv.setText(getString(R.string.UPD))
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        fun View.setOnDoubleClickListener(doubleClickInterval: Long = 500, onDoubleClick: (View) -> Unit) {
            var lastClickTime = 0L
            this.setOnClickListener { view ->
                val currentTime = SystemClock.elapsedRealtime()
                if (currentTime - lastClickTime < doubleClickInterval) {
                    onDoubleClick(view)
                }
                lastClickTime = currentTime
            }
        }
        var flag = 0
        var picture = findViewById<ImageView>(R.id.Pic)
        picture.setOnDoubleClickListener{
            if(flag == 0){
                picture.visibility = View.GONE
                flag = 1
            }else{
                flag = 0
                picture.visibility = View.VISIBLE
            }
        }
    }
}