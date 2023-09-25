package com.tecmilenio.calculadoranutricion.ui.calculadora

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculadoraSharedViewModel: ViewModel() {
    val message = MutableLiveData<Float>()
}