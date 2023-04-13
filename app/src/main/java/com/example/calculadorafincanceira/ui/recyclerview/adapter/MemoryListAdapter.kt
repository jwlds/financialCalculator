package com.example.calculadorafincanceira.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadorafincanceira.dao.MemoryDao
import com.example.calculadorafincanceira.databinding.DataItemBinding
import com.example.calculadorafincanceira.model.Memory
import com.example.calculadorafincanceira.utils.Utils.formatMonths
import com.example.calculadorafincanceira.utils.Utils.formatPercentage
import com.example.calculadorafincanceira.utils.Utils.formatValue
import com.example.calculadorafincanceira.utils.Utils.showToast


class MemoryListAdapter (
private val context: Context,
private val memorys: List<Memory>
): RecyclerView.Adapter<MemoryListAdapter.MemoryViewHolder>() {

    class MemoryViewHolder(private val binding: DataItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(memory: Memory) {


            binding.typeCalculation.text  = memory.type
            binding.value.text  = memory.value.toString()
            binding.monthTime.text  = formatMonths(memory.monthTime)
            binding.rate.text  = formatPercentage(memory.rate)
            binding.result.text = memory.result.toString()

            binding.btnDell.setOnClickListener {
                val dao = MemoryDao()
                dao.deleteById(memory.id)
            }

        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = DataItemBinding.inflate(inflater, parent, false)
        return  MemoryViewHolder(binding)
    }

    override fun getItemCount(): Int = memorys.size

    override fun onBindViewHolder(holder: MemoryViewHolder, position: Int) {
        val memory = memorys[position]
        holder.bind(memory)
    }

}