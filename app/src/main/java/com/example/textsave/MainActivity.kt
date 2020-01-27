package com.example.textsave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(),CoroutineScope{
    private lateinit var mJob: Job

    override val coroutineContext: CoroutineContext
    get() = mJob+Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mJob=Job()

        show_btn.setOnClickListener {
            var intent= Intent(this,ShowActivity::class.java)
            startActivity(intent)
        }
        save_btn.setOnClickListener {

            var entertext= enter_text.text.toString()

            launch {
                    var textData=TextData(entertext)
                    TextDataBase(this@MainActivity).getTextDao().addText(textData)
                        Toast.makeText(this@MainActivity,"Text saved",Toast.LENGTH_SHORT).show()
            }
            enter_text.text.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mJob.cancel()
    }
}
