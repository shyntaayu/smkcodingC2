package com.example.babimodii

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.babimodii.data.GithubService
import com.example.babimodii.data.apiRequest
import com.example.babimodii.data.httpClient
import com.example.babimodii.util.dismissLoading
import com.example.babimodii.util.showLoading
import com.example.babimodii.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_github.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetGithubUser()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

    private fun callApiGetGithubUser(){
        showLoading(context!!,swipeRefreshLayout)

        val httpClient= httpClient()
        val apiRequest = apiRequest<GithubService>(httpClient)

        val call = apiRequest.getUsers()
        call.enqueue(object: Callback<List<GithubUserItem>> {
            override fun onFailure(call: Call<List<GithubUserItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<GithubUserItem>>,
                response: Response<List<GithubUserItem>>
            ) {
                dismissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->
                        when{
                            response.body()?.size!=0->
                                tampilGithubUser(response.body()!!)
                            else->{
                                tampilToast(context!!,"Berhasil")
                            }
                        }
                    else->{
                        tampilToast(context!!,"Gagal")
                    }
                }
            }
        })
    }

    private fun tampilGithubUser(githubusers:List<GithubUserItem>){
        listGithubUser.layoutManager = LinearLayoutManager(context)
        Log.d("gu", githubusers.size.toString())
        listGithubUser.adapter = GithubUserAdapter(context!!,githubusers){
            val githubUser = it
            tampilToast(context!!,githubUser.login)
        }
    }
}