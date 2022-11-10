package rondarchik.calculator.converter.ui.volume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import rondarchik.calculator.converter.R
import rondarchik.calculator.converter.databinding.FragmentVolumeBinding
import rondarchik.calculator.converter.services.SpinnerListener

class VolumeFragment: Fragment() {

    private var _binding: FragmentVolumeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVolumeBinding.inflate(inflater, container, false)

        val inputEditText: EditText = binding.ioField.inputEdittext
        val outputEditText: EditText = binding.ioField.outputEdittext
        val cursor: TextView = binding.ioField.cursorPositionText
        cursor.text = "Cursor position: ${inputEditText.selectionStart} / ${inputEditText.length()}"

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false

        val inputSpinner: Spinner = binding.ioField.inputSpinner
        val outputSpinner: Spinner = binding.ioField.outputSpinner

        val spinnerListener = SpinnerListener(inputEditText, outputEditText, inputSpinner, outputSpinner)
        inputSpinner.onItemSelectedListener = spinnerListener
        outputSpinner.onItemSelectedListener = spinnerListener

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputEditText: EditText = binding.ioField.inputEdittext
        val outputEditText: EditText = binding.ioField.outputEdittext
        val cursor: TextView = binding.ioField.cursorPositionText
        cursor.text = "Cursor position: ${inputEditText.selectionStart} / ${inputEditText.length()}"

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false

        val inputSpinner: Spinner = binding.ioField.inputSpinner
        val outputSpinner: Spinner = binding.ioField.outputSpinner

        val spinnerListener = SpinnerListener(inputEditText, outputEditText, inputSpinner, outputSpinner)
        inputSpinner.onItemSelectedListener = spinnerListener
        outputSpinner.onItemSelectedListener = spinnerListener

        val adapter = ArrayAdapter.createFromResource(view.context, R.array.volume, R.layout.layout_spinner)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        inputSpinner.adapter = adapter
        outputSpinner.adapter = adapter

    }
}