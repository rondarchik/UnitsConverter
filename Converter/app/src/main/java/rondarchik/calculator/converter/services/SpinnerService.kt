package rondarchik.calculator.converter.services

import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import rondarchik.calculator.converter.converters.Converter

class SpinnerListener(private val inputValue: EditText, private val outputValue: EditText,
                      private val inputSpinner: Spinner, private val outputSpinner: Spinner
):
    AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val converter = Converter()
        converter.convert(inputValue, outputValue, inputSpinner, outputSpinner)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}