package com.example.textsave

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_show.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class ShowActivity : AppCompatActivity(),CoroutineScope {

    private lateinit var mJob: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        mJob = Job()

        fetchData()

        clear_btn.setOnClickListener {
           launch {
               TextDataBase(this@ShowActivity).getTextDao().clearTable()
           }
            fetchData()
            Snackbar.make(cordinate_layout, "Table Deleted", Snackbar.LENGTH_SHORT).show()
       }
    }
    fun fetchData()
    {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@ShowActivity)

            launch {
                val texts = TextDataBase(this@ShowActivity).getTextDao().getAllTexts()
                adapter = TextAdapter(texts)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()

        mJob.cancel()
    }
}

