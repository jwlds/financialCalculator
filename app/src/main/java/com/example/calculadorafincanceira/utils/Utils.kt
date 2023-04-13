package com.example.calculadorafincanceira.utils

import android.content.Context
import android.widget.Toast
import com.example.calculadorafincanceira.dao.MemoryDao
import com.example.calculadorafincanceira.model.FinancialCalculator

object Utils {

    fun showToast(context: Context, message: String){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }

    fun formatMonths(months: Int): String {
        return "$months meses"
    }

    fun formatPercentage(value: Double): String {
        return "Taxa: $value %"
    }

    fun formatValue(value: Double): String {
        return "Valor: $value "
    }
}