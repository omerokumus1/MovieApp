package com.example.movieapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.di.DaggerRetrofitComponent
import com.example.movieapp.utils.`interface`.PostApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class PostViewModel: ViewModel() {
    val postData = MutableLiveData<MutableList<PostModel>>()
//
//    var retrofit: Retrofit? = null
//        @Inject set
//
//    var postApi: PostApi? = null
//        @Inject set
//    @Inject

    var retrofit: Retrofit? = null
        @Inject set

//    @Inject
//    var postApi: PostApi? = null

    init {
//        gson = GsonFactory.buildGson()
//        retrofit = RetrofitFactory.buildRetrofitFrom() // service locator
        DaggerRetrofitComponent.builder().build().inject(this)

        getPosts()
    }

    fun getPosts() {
        val postApi = retrofit?.create(PostApi::class.java)
//        postApi = retrofit?.create(PostApi::class.java)
        var call: Call<List<PostModel>>? = null
        if(postApi != null)
            call = postApi.getPosts()

        /*
            call.execute ile senkron çalışırsın. Asenkron bir kodun içinde bunu kullanarak totalde
            asenkron bir yapı kullanmış olursun
         */
        call?.enqueue(object : Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>?, t: Throwable?) {

            }

            override fun onResponse(
                call: Call<List<PostModel>>?,
                response: Response<List<PostModel>>?
            ) {
                if (response?.isSuccessful == true) {
                    postData.postValue(response.body() as MutableList<PostModel>)

                }
            }

        })
    }
}