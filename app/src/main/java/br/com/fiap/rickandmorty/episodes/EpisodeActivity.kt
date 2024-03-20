package br.com.fiap.rickandmorty.episodes

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.rickandmorty.R
import br.com.fiap.rickandmorty.data.repository.RepositoryRickaAndMorty
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class EpisodeActivity: Activity() {

    private val _adapter by lazy { EpisodeAdapter() }
    private val _repo by lazy { RepositoryRickaAndMorty() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)
        setup()

    }

    override fun onResume() {
        super.onResume()
        getEpisodies()
    }

    fun getEpisodies() = runBlocking{
            launch {
                _repo.getEpisodes().await().apply {
                    _adapter.items = this.results!!
                }
        }
    }

    fun setup(){
        var recicler = findViewById<RecyclerView>(R.id.episodes)
        recicler.adapter = _adapter
        recicler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}