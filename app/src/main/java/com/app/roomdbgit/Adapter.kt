package com.app.roomdbgit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.roomdbgit.roomdb.AppDatabase
import com.app.roomdbgit.roomdb.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Adapter(val context: Context, val list: List<Data>): RecyclerView.Adapter<Adapter.Viewholder>(){
    class Viewholder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val name=itemview.findViewById<TextView>(R.id.name)
        val date=itemview.findViewById<TextView>(R.id.date)
        val pl=itemview.findViewById<TextView>(R.id.pl)
        val position=itemview.findViewById<TextView>(R.id.positional)
        val quantity=itemview.findViewById<TextView>(R.id.quantity)
        val entry=itemview.findViewById<TextView>(R.id.entry)
        val exit=itemview.findViewById<TextView>(R.id.exit)
        val total=itemview.findViewById<TextView>(R.id.total)
        val delete=itemview.findViewById<TextView>(R.id.delete)
    }

//    fun filternumber(original: List<Int>):List<Int>{
//        val positive= mutableListOf<Int>()
//
//        for (number in original) {
//            if (number > 0) {
//                positive.add(number)
//            }
//        }
//
//        return positive
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(context).inflate(R.layout.layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.name.text=list[position].CName
        holder.date.text= list[position].MiddleName
        holder.position.text=list[position].LastName
//        holder.quantity.text= list[position].quant.toString()
//        holder.entry.text=list[position].entryPrice.toString()
//        holder.exit.text=list[position].stopPrice.toString()
//        holder.total.text=list[position].pl.toString()

        val dao= AppDatabase.getInstance(context).Dao()

        holder.delete.setOnClickListener(View.OnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                dao.deleteTrade(Data(list[position].id,list[position].CName,list[position].MiddleName,list[position].LastName))
            }
        })

    }

}