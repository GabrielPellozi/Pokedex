package br.up.pokedex.network

import br.up.pokedex.models.PokeList
import retrofit2.Call
import retrofit2.http.GET

interface PokeApiService
{
    @GET("pokemon?limit=151")
    fun getPokemons():Call<PokeList>
}