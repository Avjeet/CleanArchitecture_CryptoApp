package com.express.cryptoapp.domain.model

import com.express.cryptoapp.data.remote.dto.CoinDetailDto
import com.express.cryptoapp.data.remote.dto.Tag
import com.express.cryptoapp.data.remote.dto.TeamMember
import com.express.cryptoapp.data.remote.dto.Whitepaper

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<Tag>,
    val type: String,
    val team: List<TeamMember>,
    val whitepaper: Whitepaper
)


