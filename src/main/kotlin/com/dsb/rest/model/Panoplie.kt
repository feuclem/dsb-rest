package com.dsb.rest.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Panoplie(
    var _id: Int = 0,
    var name: String = "",
    var level: String = "",
    var bonus: Bonus = Bonus(0, emptyList())
)