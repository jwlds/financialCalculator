package com.example.calculadorafincanceira.ui.calculate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.calculadorafincanceira.R
import com.example.calculadorafincanceira.dao.MemoryDao
import com.example.calculadorafincanceira.databinding.FragmentCalculateFutureBinding
import com.example.calculadorafincanceira.model.FinancialCalculator
import com.example.calculadorafincanceira.model.Memory
import com.example.calculadorafincanceira.utils.Utils


class CalculateFutureFragment : Fragment(),View.OnClickListener{

    private var _binding: FragmentCalculateFutureBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculateFutureBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCall.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btnCall -> {
                try {
                    val financialCalculator = FinancialCalculator()
                    val dao = MemoryDao()
                    val result =  financialCalculator.presentValue(
                        vf =  binding.edtVF.text.toString().trim().toDouble(),
                        i = binding.edtTaxa.text.toString().trim().toDouble(),
                        n = binding.edTMonths.text.toString().trim().toInt(),
                    )
                    binding.result.text = result.toString()
                    dao.add(
                        Memory(
                            id = dao.generateRandomId(),
                        type = "Cálculo Futuro",
                        value = binding.edtVF.text.toString().trim().toDouble(),
                        monthTime = binding.edTMonths.text.toString().trim().toInt(),
                        rate = binding.edtTaxa.text.toString().trim().toDouble(),
                        result = result
                    )
                    )
                }catch (arg: IllegalArgumentException)
                {
                    Utils.showToast(requireContext(),"Preecha todos os campos")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}