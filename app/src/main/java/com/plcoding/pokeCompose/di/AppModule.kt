package com.plcoding.pokeCompose.di

import com.plcoding.pokeCompose.data.remote.PokeApi
import com.plcoding.pokeCompose.repository.PokeRepo
import com.plcoding.pokeCompose.util.Const.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokeRepo(
        api: PokeApi
    )=PokeRepo(api)

    @Singleton
    @Provides
    fun providePokeApi() : PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(PokeApi::class.java)
    }
}