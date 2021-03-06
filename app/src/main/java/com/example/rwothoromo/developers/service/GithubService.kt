package com.example.rwothoromo.developers.service

import com.example.rwothoromo.developers.constants.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class is for the GitHub service.
 * It helps in sending out network requests to the GitHub API.
 */
class GithubService {

    private var retrofit: Retrofit? = null

    /**
     * Returns a new instance of the GithubAPI interface.
     *
     * @return GithubAPI interface
     */
    val api: GithubAPI
        get() {

            if (retrofit == null) {
                val okHttpClient = OkHttpClient()
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build()
            }

            return retrofit!!.create(GithubAPI::class.java)
        }
}
