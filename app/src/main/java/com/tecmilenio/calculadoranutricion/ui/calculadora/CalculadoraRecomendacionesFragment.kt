package com.tecmilenio.calculadoranutricion.ui.calculadora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tecmilenio.calculadoranutricion.databinding.FragmentCalculadoraRecomendacionesBinding


class CalculadoraRecomendacionesFragment : Fragment() {

    private lateinit var sharedViewModel: CalculadoraSharedViewModel

    private var _binding: FragmentCalculadoraRecomendacionesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculadoraRecomendacionesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Parte del SHARED_VIEW_MODEL
        sharedViewModel =
            ViewModelProvider(requireActivity()).get(CalculadoraSharedViewModel::class.java)

        // Observas los cambios en el MutableLiveData y actualizas la UI en consecuencia
        sharedViewModel.message.observe(viewLifecycleOwner, { resultadoCalculo ->
            //Aquí puedes usar resultadoCalculo para actualizar tu UI en el Fragmento B */
            if (resultadoCalculo < 5) {
                binding.calculadoraRecomendacionResultado.text = "Estas en Buen peso"
            } else if (resultadoCalculo > 6 && resultadoCalculo < 10) {
                binding.calculadoraRecomendacionResultado.text = "Estas en Peso Medio"
            } else if (resultadoCalculo > 10) {
                binding.calculadoraRecomendacionResultado.text = "Tienes Sobre Peso"
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
