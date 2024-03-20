package br.com.fiap.rickandmorty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rickandmorty.characters.CharactersActivity
import br.com.fiap.rickandmorty.characters.CharactersAdapter
import br.com.fiap.rickandmorty.episodes.EpisodeActivity
import br.com.fiap.rickandmorty.data.repository.RepositoryRickaAndMorty
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeActivity : Activity() {

    private val _adapter by lazy { CharactersAdapter() }
    private val _repo by lazy { RepositoryRickaAndMorty() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupAdapter()
        clicks()
    }

    override fun onResume() {
        super.onResume()
        getCharacters()
    }

    private fun getCharacters() = runBlocking {
        launch {
            var result = _repo.getCharacters().await()
            _adapter.items = result.results!!
        }
    }

    private fun setupAdapter() {
        var recicler = findViewById<RecyclerView>(R.id.characters)
        recicler.adapter = _adapter
        recicler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }

    private fun clicks(){
        _adapter.onClickItem = {
            var intent =  Intent(this, CharactersActivity::class.java)
            intent.putExtra(ID_CHARACTER, it.toString())
            startActivity(intent)

        }
    }

    companion object {
        const val ID_CHARACTER = "ID_CHARACTER"
    }
}
