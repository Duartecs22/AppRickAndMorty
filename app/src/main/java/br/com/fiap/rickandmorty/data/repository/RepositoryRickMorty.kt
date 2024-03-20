package br.com.fiap.rickandmorty.data.repository

import br.com.fiap.rickandmorty.data.RetrofitConfig
import br.com.fiap.rickandmorty.data.SchemaRickMorty
import br.com.fiap.rickandmorty.data.api.IApiRickAndMorty
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class RepositoryRickaAndMorty: IRepositoryRickMorty {

    val service = RetrofitConfig.client!!.create(IApiRickAndMorty::class.java)

    override suspend fun getEpisodes() = withContext(IO) {
        async { service.getEpisodes().await() }
    }

    override suspend fun getCharacter(character_id : String) = withContext(IO) {
        async {
            service.getCharacter(character_id).await() }
    }

    override suspend fun getCharacters() = withContext(IO) {
        async { service.getCharacters().await() }
    }
}
