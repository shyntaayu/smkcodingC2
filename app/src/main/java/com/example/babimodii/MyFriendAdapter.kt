package com.example.babimodii

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.my_friends_item.*

class MyFriendAdapter(private val context:Context, private val items:ArrayList<MyFriends>):RecyclerView.Adapter<MyFriendAdapter.ViewHolder>() {
    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
fun bindItem(item:MyFriends){
    txtFriendName.text = item.nama
    txtFriendEmail.text = item.email
    txtFriendTelp.text = item.telp
}
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.my_friends_item,parent,false)
    )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }
}