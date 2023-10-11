package com.testApp.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val list:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=list[position]
        holder.email.text=item.email
        holder.number.text=item.number
        holder.phoneNumber.text=item.phone
        holder.text.text=item.text
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val email:TextView=itemView.findViewById(R.id.emailHolder)
        val number:TextView=itemView.findViewById(R.id.numberHolder)
        val phoneNumber:TextView=itemView.findViewById(R.id.phoneHolder)
        val text:TextView=itemView.findViewById(R.id.textHolder)


    }

}