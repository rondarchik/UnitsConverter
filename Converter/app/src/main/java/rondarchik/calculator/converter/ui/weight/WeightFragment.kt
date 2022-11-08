package rondarchik.calculator.converter.ui.weight

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import rondarchik.calculator.converter.R
import rondarchik.calculator.converter.databinding.FragmentWeightBinding
import rondarchik.calculator.converter.services.SpinnerListener

class WeightFragment : Fragment() {

    private var _binding: FragmentWeightBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWeightBinding.inflate(inflater, container, false)

        val inputEditText: EditText = binding.ioField.inputEdittext
        val outputEditText: EditText = binding.ioField.outputEdittext

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false

        inputEditText.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                Toast.makeText(context, R.string.no_select, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                Toast.makeText(context, R.string.no_select, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                Toast.makeText(context, R.string.no_select, Toast.LENGTH_SHORT).show()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputEditText: EditText = binding.ioField.inputEdittext
        val outputEditText: EditText = binding.ioField.outputEdittext

        val inputSpinner: Spinner = binding.ioField.inputSpinner
        val outputSpinner: Spinner = binding.ioField.outputSpinner

        val spinnerListener = SpinnerListener(inputEditText, outputEditText, inputSpinner, outputSpinner)
        inputSpinner.onItemSelectedListener = spinnerListener
        outputSpinner.onItemSelectedListener = spinnerListener

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

        val adapter = ArrayAdapter.createFromResource(view.context, R.array.weight_list, R.layout.layout_spinner)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        inputSpinner.adapter = adapter
        outputSpinner.adapter = adapter

    }
}