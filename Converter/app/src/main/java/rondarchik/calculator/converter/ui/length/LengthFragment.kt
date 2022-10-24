package rondarchik.calculator.converter.ui.length

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import rondarchik.calculator.converter.databinding.FragmentLengthBinding

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
        val lengthViewModel =
            ViewModelProvider(this)[LengthViewModel::class.java]

        _binding = FragmentLengthBinding.inflate(inflater, container, false)

//        val textView: TextView = binding.textLength
//        lengthViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}