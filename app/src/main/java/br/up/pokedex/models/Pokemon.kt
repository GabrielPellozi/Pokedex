package br.up.pokedex.models

data class Pokemon(
    val name:String,
    val url:String
)
{
    fun id(): String
    {
        val paths = url.split("/")
        return paths[paths.size - 2]
    }
}
