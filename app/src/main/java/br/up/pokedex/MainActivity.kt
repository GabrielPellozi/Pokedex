package br.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.up.pokedex.adapters.PokeAdapter
import br.up.pokedex.network.PokeApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView =
            findViewById(R.id.main_poke_recycler)

        recyclerView.layoutManager =
            GridLayoutManager(this, 3)

        PokeApi().get {
            pokemons ->
            if(pokemons != null)
            {
                recyclerView.adapter  =
                    PokeAdapter(pokemons) {
                            pokemon ->

                    }
            }
        }
    }
}