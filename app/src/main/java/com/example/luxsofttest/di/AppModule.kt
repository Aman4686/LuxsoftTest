package com.example.luxsofttest.di

import com.example.luxsofttest.cloud.MainAPI
import com.example.luxsofttest.cloud.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseUrl() : String = "https://mocki.io/v1/"

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL : String) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideMainApi(retrofit : Retrofit): MainAPI = retrofit.create(MainAPI::class.java)

    @Provides
    fun provideMainRepository(mainAPI: MainAPI): MainRepository = MainRepository(mainAPI)

}