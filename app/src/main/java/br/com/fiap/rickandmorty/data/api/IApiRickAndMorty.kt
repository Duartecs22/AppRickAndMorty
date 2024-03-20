package br.com.fiap.rickandmorty.data.api

import br.com.fiap.rickandmorty.data.SchemaRickMorty
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiRickAndMorty {

        @GET("episode")
        fun getEpisodes(): Deferred<SchemaRickMorty.ResultEpisode>

        @GET("character/{id}")
        fun getCharacter(@Path("id") id: String): Deferred<SchemaRickMorty.Characters>

        @GET("character")
        fun getCharacters(): Deferred<SchemaRickMorty.ResultCharacter>
}