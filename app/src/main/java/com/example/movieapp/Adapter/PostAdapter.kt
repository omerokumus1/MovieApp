package com.example.movieapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Model.PostModel
import com.example.movieapp.R

class PostAdapter(private val postModels: MutableList<PostModel>, val context: Context) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>()
    {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewId: TextView = itemView.findViewById(R.id.textViewId)
        var textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        var textViewBody: TextView = itemView.findViewById(R.id.textViewBody)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = postModels[position]
        holder.textViewId.text = item.id.toString()
        holder.textViewTitle.text = item.title
        holder.textViewBody.text = item.title

    }

    override fun getItemCount(): Int {
        return postModels.size
    }
}