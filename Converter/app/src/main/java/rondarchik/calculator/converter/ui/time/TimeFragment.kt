package rondarchik.calculator.converter.ui.time

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rondarchik.calculator.converter.R
import rondarchik.calculator.converter.databinding.FragmentTimeBinding
import rondarchik.calculator.converter.services.SpinnerListener

class TimeFragment : Fragment() {

    private var _binding: FragmentTimeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTimeBinding.inflate(inflater, container, false)

        val inputEditText: EditText = binding.ioField.inputEdittext
        inputEditText.setText("0")

        val outputEditText: EditText = binding.ioField.outputEdittext
        outputEditText.setText("0")

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false

        inputEditText.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                return false
            }

            override fun onDestroyActionMode(p0: ActionMode?) {

            }
        }

        val inputSpinner: Spinner = binding.ioField.inputSpinner
        val outputSpinner: Spinner = binding.ioField.outputSpinner

        val spinnerListener = SpinnerListener(inputEditText, outputEditText, inputSpinner, outputSpinner)
        inputSpinner.onItemSelectedListener = spinnerListener
        outputSpinner.onItemSelectedListener = spinnerListener

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val timeViewModel = ViewModelProvider(this)[TimeViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputSpinner: Spinner = binding.ioField.inputSpinner
        val outputSpinner: Spinner = binding.ioField.outputSpinner

        val inputEditText: EditText = binding.ioField.inputEdittext
        val outputEditText: EditText = binding.ioField.outputEdittext

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false

        inputEditText.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                return false
            }

            override fun onDestroyActionMode(p0: ActionMode?) {

            }
        }

        val adapter = ArrayAdapter.createFromResource(view.context, R.array.time_list, R.layout.layout_spinner)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        inputSpinner.adapter = adapter
        outputSpinner.adapter = adapter

    }
}