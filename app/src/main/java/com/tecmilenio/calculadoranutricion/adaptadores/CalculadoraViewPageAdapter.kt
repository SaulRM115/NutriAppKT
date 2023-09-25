package com.tecmilenio.calculadoranutricion.adaptadores

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tecmilenio.calculadoranutricion.ui.calculadora.CalculadoraFragment
import com.tecmilenio.calculadoranutricion.ui.calculadora.CalculadoraRecomendacionesFragment

class CalculadoraViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> CalculadoraFragment()
            else -> CalculadoraRecomendacionesFragment()
        }
}