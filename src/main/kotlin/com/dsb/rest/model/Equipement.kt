package com.dsb.rest.model

data class Equipement(
    var _id: Int = 0,
    var name: String = "",
    var level: String = "",
    var imgUrl: String = "",
    var statistics: List<Statistic> = emptyList(),
    var type: String = ""
)