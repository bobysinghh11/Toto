package com.stuffshuf.toto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stuffshuf.toto.TodoAdapter.Companion.DESC
import com.stuffshuf.toto.TodoAdapter.Companion.TITELE
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        btnsave.setOnClickListener {

            var intent= Intent(this, Main2Activity::class.java)
            intent.putExtra(TITELE, etNewItem.text.toString())
            intent.putExtra(DESC, etNewItem1.text.toString())
            startActivity(intent)
            finish()

        }

       var title= intent.getStringExtra(TITELE)
        var desc =intent.getStringExtra(DESC)
//        etNewItem.text.toString()=title
//        etNewItem1.text=desc
        etNewItem.setText(title)
        etNewItem1.setText(desc)


    }
}
