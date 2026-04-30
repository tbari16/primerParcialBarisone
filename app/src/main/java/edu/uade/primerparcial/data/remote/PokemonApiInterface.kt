package edu.uade.primerparcial.data.remote

import edu.uade.primerparcial.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int = 251,
        @Query("offset") offset: Int = 0
    ): PokemonResponse
}