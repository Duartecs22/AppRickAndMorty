package br.com.fiap.rickandmorty.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class SchemaRickMorty {

    //PERSONAGENS
    @JsonClass(generateAdapter = true)
    data class Characters(
        @field:Json(name = "id")
        val id: Int,
        @field:Json(name = "name")
        val name: String?,
        @field:Json(name = "status")
        val status: String?,
        @field:Json(name = "species")
        val species: String?,
        @field:Json(name = "type")
        val type: String?,
        @field:Json(name = "gender")
        val gender: String?,
        @field:Json(name = "origin")
        val origin: Origin?,
        @field:Json(name = "location")
        val location: Origin?,
        @field:Json(name = "image")
        val image: String?,
        @field:Json(name = "episode")
        val episode: List<String>?,
        @field:Json(name = "url")
        val url: String?,
        @field:Json(name = "created")
        val created: String?)

    @JsonClass(generateAdapter = true)
    data class Origin(
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "url")
        val url: String
    )

    //LOCATIONS
    @JsonClass(generateAdapter = true)
    data class Locations(
        @field:Json(name = "id")
        val id: Int?,
        @field:Json(name = "name")
        val name: String?,
        @field:Json(name = "type")
        val string: String?,
        @field:Json(name = "dimension")
        val dimension: String?,
        @field:Json(name = "residents")
        val residents: List<String>?,
        @field:Json(name = "url")
        val url: String?,
        @field:Json(name = "created")
        val created: String?)

    //EPISODE
    @JsonClass(generateAdapter = true)
    data class Episode(
        @field:Json(name = "id")
        val id: Int?,
        @field:Json(name = "name")
        val name: String?,
        @field:Json(name = "air_date")
        val air_date: String?,
        @field:Json(name = "episode")
        val episode: String?,
        @field:Json(name = "characters")
        val characters: List<String>?,
        @field:Json(name = "url")
        val url: String?,
        @field:Json(name = "crated")
        val created: String?)

    @JsonClass(generateAdapter = true)
    data class ResultEpisode(
        @field:Json(name = "info")
        val info: Info?,
        @field:Json(name = "results")
        val results: List<Episode>?
    )

    @JsonClass(generateAdapter = true)
    data class ResultCharacter(
        @field:Json(name = "info")
        val info: Info?,
        @field:Json(name = "results")
        val results: List<Characters>?
    )

    @JsonClass(generateAdapter = true)
    data class Info(
        @field:Json(name = "count")
         val count: Int?,
        @field:Json(name = "pages")
         val pages: Int?,
        @field:Json(name = "next")
         val next: String,
        @field:Json(name = "prev")
        val prev: String?
    )
}
