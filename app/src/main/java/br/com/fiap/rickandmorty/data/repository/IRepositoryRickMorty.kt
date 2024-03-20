package br.com.fiap.rickandmorty.data.repository

import br.com.fiap.rickandmorty.data.SchemaRickMorty
import kotlinx.coroutines.Deferred

interface IRepositoryRickMorty {
        suspend fun getEpisodes(): Deferred<SchemaRickMorty.ResultEpisode>
        suspend fun getCharacter(character_id : String): Deferred<SchemaRickMorty.Characters>
        suspend fun getCharacters(): Deferred<SchemaRickMorty.ResultCharacter>
}