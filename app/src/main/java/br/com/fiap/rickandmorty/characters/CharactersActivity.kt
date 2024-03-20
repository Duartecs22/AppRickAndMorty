package br.com.fiap.rickandmorty.characters

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rickandmorty.HomeActivity
import br.com.fiap.rickandmorty.R
import br.com.fiap.rickandmorty.data.SchemaRickMorty
import br.com.fiap.rickandmorty.data.repository.RepositoryRickaAndMorty
import br.com.fiap.rickandmorty.episodes.EpisodeAdapter
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CharactersActivity : Activity() {

    private val _adapter by lazy { EpisodeAdapter() }
    private val _repo by lazy { RepositoryRickaAndMorty() }
    private val _character_id by lazy { intent.getStringExtra(HomeActivity.ID_CHARACTER) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        setupAdapter()
        setupToolbar()
    }

    private fun setupToolbar(){
        var button = findViewById<ImageView>(R.id.toolbar_close_image_view)
        button.isVisible = true
        button.setOnClickListener {
          finish()
        }
    }

    override fun onResume() {
        super.onResume()
        getCharacters()

    }

    private fun getDataScreen(schemaRickMorty: SchemaRickMorty.Characters){
        var name = findViewById<TextView>(R.id.name_value)
        var specie = findViewById<TextView>(R.id.specie_value)
        var status = findViewById<TextView>(R.id.status_value)
        var gender = findViewById<TextView>(R.id.gender_value)
        var origin = findViewById<TextView>(R.id.origin_value)
        var img_character = findViewById<ImageView>(R.id.img_character)


        name.text = schemaRickMorty.name
        specie.text = schemaRickMorty.species
        status.text = schemaRickMorty.status
        gender.text = schemaRickMorty.gender
        origin.text = schemaRickMorty.origin?.name

        Picasso.get()
            .load(schemaRickMorty.image)
            .into(img_character)

    }

    private fun getCharacters() = runBlocking {
        launch {
            var result = _character_id?.let { _repo.getCharacter(it).await() }
            if (result != null) {
                getDataScreen(result)
            }
        }
    }

    private fun setupAdapter() {
        var recicler = findViewById<RecyclerView>(R.id.characters)
        recicler.adapter = _adapter
        recicler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}