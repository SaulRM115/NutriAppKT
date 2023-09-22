package com.tecmilenio.calculadoranutricion.ui.calculadora


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tecmilenio.calculadoranutricion.R
import com.tecmilenio.calculadoranutricion.databinding.FragmentCalculadoraBinding


class CalculadoraFragment : Fragment() {
    private var _binding: FragmentCalculadoraBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculadoraBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculadoraBtnResultado.setOnClickListener{
            val valorIngresadoTxt = binding.calculadoraInputValor.text.toString()
            val valorIngresadoFloat: Float? = valorIngresadoTxt.toFloatOrNull()

            if(valorIngresadoFloat != null){
                val resultadoCalculo = valorIngresadoFloat + 2
                binding.calculadoraResultado.text = "La suma de $valorIngresadoFloat + 2 es $resultadoCalculo"
            } else {
                binding.calculadoraResultado.text = getString(R.string.ingrese_un_numero_valido)

            }
        }
    }
}
