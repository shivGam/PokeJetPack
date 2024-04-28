package com.plcoding.pokeCompose.repository

import com.plcoding.pokeCompose.data.remote.PokeApi
import com.plcoding.pokeCompose.data.remote.responses.Pokemon
import com.plcoding.pokeCompose.data.remote.responses.PokemonList
import com.plcoding.pokeCompose.util.Resources
import com.plcoding.pokeCompose.util.Resources.Error
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokeRepo @Inject constructor(
    private val pokeApi: PokeApi
){
    suspend fun getPokemonList(limit :Int , offset: Int) : Resources<PokemonList> {
        val response = try {
            pokeApi.getPokeList(limit,offset)
        }
        catch (e: Exception){
            return Error("Error Occurred")
        }
        return Resources.Success(response)
    }
    suspend fun getPokemon(pokeName : String) : Resources<Pokemon> {
        val response = try {
            pokeApi.getPokemon(pokeName)
        }
        catch (e: Exception){
            return Error("Error Occurred")
        }
        return Resources.Success(response)
    }
}