package com.example.movieapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.MyApp
import com.example.movieapp.R
import com.example.movieapp.utils.adapter.PostAdapter
import com.example.movieapp.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var postViewModel: PostViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPostBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_post, container, false
        )


        recyclerView = binding.recyclerView
//        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)

//        MyApp.appComponent.inject()

        initPosts()
        return binding.root
    }

    private fun initPosts() { // DifUtil uygula: datayı değiştirmek için
        postViewModel?.postData?.observe(viewLifecycleOwner, { postModels ->
            val postAdapter =
                PostAdapter(postModels) // yeni adaptör oluşturuyor, sorun mu? Evet, onun yerine DifUtil ile datayı değiştir
            recyclerView?.adapter = postAdapter
        })
    }


}