package com.app.roomdbgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.roomdbgit.roomdb.AppDatabase
import com.app.roomdbgit.roomdb.Dao

class GettingData : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var list:ArrayList<String>
    private lateinit var dao: Dao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_data)

        recyclerView=findViewById(R.id.recycler)

        val db= AppDatabase.getInstance(applicationContext)
        dao=db.Dao()

        recyclerView.layoutManager= LinearLayoutManager(this)

        list=ArrayList()

//        dao.getAllTrade().

        dao.getAllTrade().observe(this) {
            recyclerView.adapter = Adapter(applicationContext, it)
            list.addAll(listOf(dao.toString()))
            recyclerView.adapter?.notifyDataSetChanged()
            Log.d("ret", "onCreate: " + it)
        }

    }
}