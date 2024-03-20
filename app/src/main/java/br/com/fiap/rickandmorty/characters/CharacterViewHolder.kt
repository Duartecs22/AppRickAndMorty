package br.com.fiap.rickandmorty.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rickandmorty.R
import br.com.fiap.rickandmorty.data.SchemaRickMorty
import com.squareup.picasso.Picasso

class CharacterViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun inflate(viewGroup: ViewGroup) = CharacterViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_character, viewGroup, false)
        )
    }

    operator fun invoke(item: SchemaRickMorty.Characters, onClickItem: ((Int) -> Unit)?){
        with(itemView) {
            var name = findViewById<TextView>(R.id.name_value)
            var specie = findViewById<TextView>(R.id.specie_value)
            var status = findViewById<TextView>(R.id.status_value)
            var img_character = findViewById<ImageView>(R.id.img_character)

            name.text = item.name
            specie.text = item.species
            status.text = item.status

            Picasso.get()
                 .load(item.image)
                 .into(img_character)

            itemView.setOnClickListener {
                onClickItem?.invoke(item.id)
            }
        }
    }
}