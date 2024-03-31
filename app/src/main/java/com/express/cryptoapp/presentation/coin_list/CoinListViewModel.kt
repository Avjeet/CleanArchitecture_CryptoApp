package com.express.cryptoapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.express.cryptoapp.common.Resource
import com.express.cryptoapp.domain.use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state


    init {
        getCoins()

    }

    private fun getCoins() = viewModelScope.launch {
        getCoinsUseCase().collect { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins =  result.data?: emptyList())
                    _state.value = _state.value.copy()
                }

                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message?: "Unexpected error")
                }

                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }
    }
}