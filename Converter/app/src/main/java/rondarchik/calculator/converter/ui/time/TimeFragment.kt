package rondarchik.calculator.converter.ui.time

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rondarchik.calculator.converter.databinding.FragmentTimeBinding

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
}