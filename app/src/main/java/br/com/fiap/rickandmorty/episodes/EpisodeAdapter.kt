package br.com.fiap.rickandmorty.episodes

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rickandmorty.data.SchemaRickMorty

class EpisodeAdapter: RecyclerView.Adapter<EpisodeViewHolder>() {

    var items: List<SchemaRickMorty.Episode> = listOf()
       set(newList){
           field = newList
           notifyDataSetChanged()
       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  EpisodeViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder(items[position])
    }

    override fun getItemCount() = items.size
}