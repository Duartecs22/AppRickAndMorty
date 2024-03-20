package br.com.fiap.rickandmorty.characters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rickandmorty.data.SchemaRickMorty

class CharactersAdapter: RecyclerView.Adapter<CharacterViewHolder>() {
    var onClickItem: ((Int) -> Unit)? = null
    var items: List<SchemaRickMorty.Characters> = listOf()

    set(newList){
        field = newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  CharacterViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder(items[position], onClickItem)
    }

    override fun getItemCount() = items.size
}