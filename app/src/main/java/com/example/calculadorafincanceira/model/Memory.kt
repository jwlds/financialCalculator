package com.example.calculadorafincanceira.model

import java.util.*

data class  Memory(
    val id: UUID,
    var type: String,
    val value: Double,
    val monthTime: Int,
    val rate: Double,
    val result: Double,
)