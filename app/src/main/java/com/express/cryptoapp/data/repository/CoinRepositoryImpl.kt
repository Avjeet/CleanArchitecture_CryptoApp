package com.express.cryptoapp.data.repository

import com.express.cryptoapp.common.Resource
import com.express.cryptoapp.data.remote.CoinsRemoteDataSource
import com.express.cryptoapp.domain.model.Coin
import com.express.cryptoapp.domain.model.CoinDetail
import com.express.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val coinsRemoteDataSource: CoinsRemoteDataSource) : CoinRepository {
    override suspend fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        emit(coinsRemoteDataSource.getCoins())
    }

    override suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        emit(coinsRemoteDataSource.getCoinDetail(coinId))
    }
}