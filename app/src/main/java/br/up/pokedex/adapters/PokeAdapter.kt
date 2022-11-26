package br.up.pokedex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.up.pokedex.R
import br.up.pokedex.models.Pokemon
import com.squareup.picasso.Picasso

class PokeAdapter(
    private val pokemons: List<Pokemon>,
    private val listener:(pokemon: Pokemon) -> Unit) :
    RecyclerView.Adapter
    <PokeAdapter.PokeViewHolder>()
{
    inner class PokeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)

        val layout = inflater
            .inflate(R.layout.poke_view_item,
                parent,
                false)

        return PokeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int)
    {

        val pokemon = pokemons[position]

        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id()}.png"

        val imageView : ImageView = holder.itemView.findViewById(R.id.image_poke_view)

        holder.itemView.setOnClickListener {
            listener(pokemon)
        }

        Picasso.get().load(url).into(imageView)
    }

    override fun getItemCount(): Int
    {
        return pokemons.size
    }
}