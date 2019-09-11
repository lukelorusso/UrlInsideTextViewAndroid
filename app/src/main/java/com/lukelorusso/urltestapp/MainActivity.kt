package com.lukelorusso.urltestapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // done programmatically
        val textExample1 = getString(R.string.textExample1)
        textView2.text = textExample1
        Linkify.addLinks(textView2, Linkify.WEB_URLS)

        // done programmatically with an HTML-like text: <a href.../>
        val textExample2 = getString(R.string.textExample2)
        textView3.movementMethod = LinkMovementMethod.getInstance()
        textView3.text = textExample2.toHtml()
    }
}

@Suppress("DEPRECATION")
fun String.toHtml(): Spanned =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(this)
        }
