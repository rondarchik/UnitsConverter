package rondarchik.calculator.converter.ui.length

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LengthViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Length Fragment"
    }
    val text: LiveData<String> = _text
}