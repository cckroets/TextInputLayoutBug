package com.github.cckroets.textinputlayoutbug

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val layout = findViewById<TextInputLayout>(R.id.text_layout)
        fab.setOnClickListener { _ ->
            // Clipped text when the same error is shown twice. This is due to the animation being immediately cancelled
            // but not started again
            layout.error = "Please fix, this is clipped"
            layout.error = "Please fix, this is clipped"
        }
    }
}
