package rondarchik.calculator.converter.ui.weight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rondarchik.calculator.converter.databinding.FragmentWeightBinding
import rondarchik.calculator.converter.ui.length.LengthViewModel

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
        inputEditText.setText("0")

        val outputEditText: EditText = binding.ioField.outputEdittext
        outputEditText.setText("0")

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val weightViewModel = ViewModelProvider(this)[WeightViewModel::class.java]

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}