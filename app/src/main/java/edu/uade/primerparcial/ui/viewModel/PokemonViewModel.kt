package edu.uade.primerparcial.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uade.primerparcial.data.model.Pokemon
import edu.uade.primerparcial.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokemonRepository = PokemonRepository()
) : ViewModel() {

    private val _pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = _pokemons.asStateFlow()

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            try {
                _pokemons.value = repository.getPokemons()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}