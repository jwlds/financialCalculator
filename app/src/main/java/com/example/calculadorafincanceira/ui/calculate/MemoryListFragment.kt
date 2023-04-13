package com.example.calculadorafincanceira.ui.calculate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.calculadorafincanceira.R
import com.example.calculadorafincanceira.dao.MemoryDao
import com.example.calculadorafincanceira.databinding.FragmentMemoryListBinding
import com.example.calculadorafincanceira.ui.recyclerview.adapter.MemoryListAdapter


class MemoryListFragment : Fragment() {

    private var _binding: FragmentMemoryListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMemoryListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.bottomBar.bottomNavigation.setOnItemReselectedListener { item ->
//            when(item.itemId) {
//
//                R.id.btnPresent -> {
//                    findNavController().navigate(R.id.action_memoryListFragment_to_calculatePresentFragment)
//                }
//                R.id.btnFuture -> {
//                    findNavController().navigate(R.id.action_memoryListFragment_to_calculateFutureFragment)
//                }
//            }
//        }
    }
    override fun onResume() {
        super.onResume()
        val dao = MemoryDao()
        binding.memoryList.adapter = MemoryListAdapter(requireContext(), dao.getAll())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}