package com.app.roomdbgit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var add:Button
    private lateinit var recycler:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add=findViewById(R.id.adddata)
        recycler=findViewById(R.id.getdata)


        add.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,AddingData::class.java))
        })

        recycler.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,GettingData::class.java))
        })

    }
}