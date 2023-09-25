package com.tecmilenio.calculadoranutricion.ui.calculadora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.tecmilenio.calculadoranutricion.R
import com.tecmilenio.calculadoranutricion.adaptadores.CalculadoraViewPageAdapter
import com.tecmilenio.calculadoranutricion.databinding.FragmentCalculadoraMainContainerBinding

class CalculadoraMainFragmentContainer: Fragment() {

    private var _binding: FragmentCalculadoraMainContainerBinding? = null
    private val binding get() = _binding!!


    private lateinit var sharedViewModel: CalculadoraSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculadoraMainContainerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        sharedViewModel = ViewModelProvider(requireActivity()).get(CalculadoraSharedViewModel::class.java)

        val adapter = CalculadoraViewPageAdapter(childFragmentManager, lifecycle)
        val viewPager: ViewPager2 = view.findViewById(R.id.calculadora_ViewPager)
        viewPager.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}