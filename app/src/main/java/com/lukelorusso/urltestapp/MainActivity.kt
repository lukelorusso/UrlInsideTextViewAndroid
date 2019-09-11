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
        val text2 = getString(R.string.textView1)
        textView2.text = text2
        Linkify.addLinks(textView2, Linkify.WEB_URLS)

        // done programmatically with <a href.../>
        val text3 = "This is also <a href=\"http://www.lukelorusso.com\">a link</a>!"
        textView3.movementMethod = LinkMovementMethod.getInstance()
        textView3.text = text3.toHtml()
    }
}

@Suppress("DEPRECATION")
fun String.toHtml(): Spanned =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(this)
        }
