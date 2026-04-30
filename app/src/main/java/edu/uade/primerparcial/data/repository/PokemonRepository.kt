package edu.uade.primerparcial.data.repository

import edu.uade.primerparcial.data.model.Pokemon
import edu.uade.primerparcial.data.remote.RetrofitInstance

class PokemonRepository {

    suspend fun getPokemons(): List<Pokemon> {
        return RetrofitInstance.api.getPokemons().results
    }
}