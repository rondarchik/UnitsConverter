package rondarchik.calculator.converter.ui.length

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rondarchik.calculator.converter.converters.Converter
import rondarchik.calculator.converter.databinding.FragmentLengthBinding
import rondarchik.calculator.converter.services.SpinnerOnItemSelectedListener


class LengthFragment : Fragment() {

    private var _binding: FragmentLengthBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLengthBinding.inflate(inflater, container, false)

        val inputEditText: EditText = binding.ioField.inputEdittext
        inputEditText.setText("0")

        val outputEditText: EditText = binding.ioField.outputEdittext
        outputEditText.setText("0")

        val inputSpinner: Spinner = binding.ioField.inputSpinner
        val outputSpinner: Spinner = binding.ioField.outputSpinner

        val spinnerListener = SpinnerOnItemSelectedListener(inputEditText, outputEditText, inputSpinner, outputSpinner)
        inputSpinner.onItemSelectedListener = spinnerListener
        outputSpinner.onItemSelectedListener = spinnerListener

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val lengthViewModel = ViewModelProvider(this)[LengthViewModel::class.java]

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}