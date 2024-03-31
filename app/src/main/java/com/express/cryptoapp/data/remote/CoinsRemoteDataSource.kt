package com.express.cryptoapp.data.remote

import com.express.cryptoapp.common.Resource
import com.express.cryptoapp.data.remote.dto.toCoin
import com.express.cryptoapp.data.remote.dto.toCoinDetail
import com.express.cryptoapp.domain.model.Coin
import com.express.cryptoapp.domain.model.CoinDetail
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinsRemoteDataSource @Inject constructor(private val api: CoinPaprikaApi) {

    suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            val coins = api.getCoins().map { it.toCoin() }
            Resource.Success(coins)
        } catch (e: HttpException) {
            (Resource.Error(e.localizedMessage ?: "Unexpected Error Occured"))
        } catch (e: IOException) {
            (Resource.Error(e.localizedMessage ?: "Couldn't reach Server"))
        }
    }

    suspend fun getCoinDetail(coinId: String): Resource<CoinDetail> {
        return try {
            val coin = api.getCoinById(coinId).toCoinDetail()
            Resource.Success(coin)
        } catch (e: HttpException) {
            (Resource.Error(e.localizedMessage ?: "Unexpected Error Occured"))
        } catch (e: IOException) {
            (Resource.Error(e.localizedMessage ?: "Couldn't reach Server"))
        }
    }

}