package br.com.fiap.rickandmorty.data.model

import br.com.fiap.rickandmorty.data.SchemaRickMorty
import com.squareup.moshi.JsonClass

class RickMortyModel {

    data class CharactersModel(
        val id: Int?,
        val name: String?,
        val status: String?,
        val species: String?,
        val type: String?,
        val gender: String?,
        val origin: Object?,
        val location: Object?,
        val image: String?,
        val episode: List<String>?,
        val url: String?,
        val created: String?)

    //LOCATIONS
    data class LocationsModel(
        val id: Int?,
        val name: String?,
        val string: String?,
        val dimension: String?,
        val residents: List<String>?,
        val url: String?,
        val created: String?)

    //EPISODE
    @JsonClass(generateAdapter = true)
    data class EpisodeModel(
        val id: Int?,
        val name: String?,
        val air_date: String?,
        val episode: String?,
        val characters: List<String>?,
        val url: String?,
        val created: String?)

    data class ResultEpisodeModel(
        val info: InfoModel?,
        val results: List<EpisodeModel>?
    )

    data class ResultCharacterModel(
        val info: InfoModel?,
        val results: List<SchemaRickMorty.Characters>?
    )

    data class InfoModel(
        val  count: Int?,
        val pages: Int?,
        val next: String,
        val prev: String?
    )
}