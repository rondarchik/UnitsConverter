package rondarchik.calculator.converter.ui.time

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Time Fragment"
    }
    val text: LiveData<String> = _text
}