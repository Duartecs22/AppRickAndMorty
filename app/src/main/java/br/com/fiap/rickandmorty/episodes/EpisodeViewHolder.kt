package br.com.fiap.rickandmorty.episodes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rickandmorty.R
import br.com.fiap.rickandmorty.data.SchemaRickMorty

class EpisodeViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun inflate(viewGroup: ViewGroup) = EpisodeViewHolder(
              LayoutInflater.from(viewGroup.context).inflate(R.layout.item_episode, viewGroup, false)
        )
    }

    operator fun invoke(item: SchemaRickMorty.Episode){
        with(itemView){
            var name_value = findViewById<TextView>(R.id.name_value)
            var episode_value = findViewById<TextView>(R.id.episode_value)
            var date_value = findViewById<TextView>(R.id.date_value)

            name_value.text = item.name
            episode_value.text = item.episode
            date_value.text = item.air_date
        }
    }
}