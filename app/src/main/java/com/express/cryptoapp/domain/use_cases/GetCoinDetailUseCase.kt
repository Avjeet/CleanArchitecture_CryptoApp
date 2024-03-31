package com.express.cryptoapp.domain.use_cases

import com.express.cryptoapp.common.Resource
import com.express.cryptoapp.domain.model.CoinDetail
import com.express.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = repository.getCoinById(coinId)
}
