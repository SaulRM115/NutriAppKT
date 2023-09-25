package com.tecmilenio.calculadoranutricion.ui.calculadora


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        _binding = FragmentCalculadoraBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Parte del SHARED_VIEW_MODEL
    private lateinit var calculadora_sharedViewModel: CalculadoraSharedViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Parte del SHARED_VIEW_MODEL
        calculadora_sharedViewModel =
            ViewModelProvider(requireActivity()).get(CalculadoraSharedViewModel::class.java)

        binding.calculadoraBtnResultado.setOnClickListener {
            val valorIngresadoTxt = binding.calculadoraInputValor.text.toString()
            val valorIngresadoFloat: Float? = valorIngresadoTxt.toFloatOrNull()

            if (valorIngresadoFloat != null) {
                val resultadoCalculo = valorIngresadoFloat + 2
                calculadora_sharedViewModel.message.value = resultadoCalculo //  actualiza el valor del MutableLiveData<Float> en tu SharedViewModel
                binding.calculadoraResultado.text =
                    "La suma de $valorIngresadoFloat + 2 es $resultadoCalculo"
            } else {
                binding.calculadoraResultado.text = getString(R.string.ingrese_un_numero_valido)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
