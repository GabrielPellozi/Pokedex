package br.up.pokedex.network

import br.up.pokedex.models.PokeList
import br.up.pokedex.models.Pokemon
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class PokeApi()
{
    companion object
    {
        private var retrofit:Retrofit? = null
        private var service:PokeApiService? = null

        init
        {
            if(retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                service = retrofit?.create(PokeApiService::class.java)
            }
        }
    }

    fun get(callback: (pokemons:List<Pokemon>?) -> Unit)
    {
        service?.getPokemons()?.enqueue (
            object  : Callback<PokeList>
            {
                override fun onResponse(call: Call<PokeList>, response: Response<PokeList>)
                {
                    callback.invoke(response.body()?.pokemons)
                }

                override fun onFailure(call: Call<PokeList>, t: Throwable)
                {
                    callback.invoke(null)
                }
            }
        )
    }
}