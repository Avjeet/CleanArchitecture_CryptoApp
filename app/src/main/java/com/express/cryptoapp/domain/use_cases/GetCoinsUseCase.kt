package com.express.cryptoapp.domain.use_cases

import com.express.cryptoapp.common.Resource
import com.express.cryptoapp.data.remote.dto.toCoin
import com.express.cryptoapp.domain.model.Coin
import com.express.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }
}