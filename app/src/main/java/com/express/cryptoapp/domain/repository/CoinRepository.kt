package com.express.cryptoapp.domain.repository

import com.express.cryptoapp.common.Resource
import com.express.cryptoapp.domain.model.Coin
import com.express.cryptoapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getCoins(): Flow<Resource<List<Coin>>>

    suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}