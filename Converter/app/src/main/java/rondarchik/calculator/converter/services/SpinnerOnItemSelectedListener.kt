package rondarchik.calculator.converter.services

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.EditText
import android.widget.Spinner
import rondarchik.calculator.converter.converters.Converter

class SpinnerOnItemSelectedListener(val inputValue: EditText, val outputValue: EditText,
                                    val inputSpinner: Spinner, val outputSpinner: Spinner): OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val converter = Converter()
        converter.convert(inputValue, outputValue, inputSpinner, outputSpinner)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}