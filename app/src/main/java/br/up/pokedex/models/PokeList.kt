package br.up.pokedex.models

import com.google.gson.annotations.SerializedName

data class PokeList(
    @SerializedName("results")
    val pokemons:List<Pokemon>
)
