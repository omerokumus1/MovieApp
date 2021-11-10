package com.example.movieapp.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.ui.list.PostModel

class PostAdapter(private val postModels: MutableList<PostModel>) :
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
        // scope functions: run, apply vs
        postModels[position].run {
            holder.textViewId.text = id.toString()
            holder.textViewTitle.text = title
            holder.textViewBody.text = body
        }
//        holder.run {
//            textViewId.text = postModels[position].id.toString()
//            textViewTitle.text = postModels[position].title
//            textViewBody.text = postModels[position].body
//        }
//        holder.textViewId.text = item.id.toString()
//        holder.textViewTitle.text = item.title
//        holder.textViewBody.text = item.body

    }

    override fun getItemCount() = postModels.size
}