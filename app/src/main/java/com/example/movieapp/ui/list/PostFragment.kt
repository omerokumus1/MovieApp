package com.example.movieapp.ui.list

import android.content.Context
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
import com.example.movieapp.utils.interfaces.PostApi
import retrofit2.Retrofit
import javax.inject.Inject

class PostFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var postViewModel: PostViewModel? = null

    @Inject
    lateinit var postApi: PostApi

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPostBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_post, container, false
        )


        recyclerView = binding.recyclerView
        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)


        initPosts()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MyApp.appComponent.inject(this)
    }

    private fun initPosts() { // DifUtil uygula: datayı değiştirmek için
        postViewModel?.postData?.observe(viewLifecycleOwner, { postModels ->
            val postAdapter =
                PostAdapter(postModels) // yeni adaptör oluşturuyor, sorun mu? Evet, onun yerine DifUtil ile datayı değiştir
            recyclerView?.adapter = postAdapter
        })
    }


}