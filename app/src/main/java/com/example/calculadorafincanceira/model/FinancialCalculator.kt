package com.example.calculadorafincanceira.model

import kotlin.math.pow
// val vf: Double? = null, val vp: Double? = null, val i: Double, val n: Int
class FinancialCalculator(){

    fun presentValue(vf: Double, i: Double, n: Int): Double {
        return vf / (1 + i).pow(n.toDouble())
    }

    fun futureValue(vp: Double, i: Double, n: Int): Double {
        return vp * (1 + i).pow(n.toDouble())
    }

}