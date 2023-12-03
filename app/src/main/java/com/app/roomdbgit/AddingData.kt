package com.app.roomdbgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.app.roomdbgit.roomdb.AppDatabase
import com.app.roomdbgit.roomdb.Dao
import com.app.roomdbgit.roomdb.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddingData : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var middle:EditText
    private lateinit var last:EditText
    private lateinit var save:Button
    private lateinit var dao: Dao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_data)

        name=findViewById(R.id.name)
        middle=findViewById(R.id.middle)
        last=findViewById(R.id.last)
        save=findViewById(R.id.save)

        val db= AppDatabase.getInstance(applicationContext)
        dao=db.Dao()

        save.setOnClickListener(View.OnClickListener {

            val names=name.text.toString()
            val middlename=middle.text.toString()
            val lastname=last.text.toString()

            val adding=Data(CName = names, MiddleName = middlename, LastName = lastname)
            GlobalScope.launch(Dispatchers.IO) {
                dao.insertTrade(adding)
//                Toast.makeText(this@AddingData,"Data Saved",Toast.LENGTH_LONG).show()
//                in this toast is not implementing
            }

        })

    }
}