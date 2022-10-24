package rondarchik.calculator.converter

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import rondarchik.calculator.converter.databinding.ActivityMainBinding
import rondarchik.calculator.converter.services.InputService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var inputService: InputService

    private lateinit var inputEditText: EditText
    private lateinit var  outputEditText: EditText
    private lateinit var  inputSpinner: Spinner
    private lateinit var  outputSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        inputEditText = findViewById(R.id.input_edittext)
        outputEditText = findViewById(R.id.output_edittext)
        inputSpinner = findViewById(R.id.input_spinner)
        outputSpinner = findViewById(R.id.output_spinner)
    }

    override fun onStart() {
        super.onStart()

        this.inputService = InputService(this.applicationContext)
    }

    fun onNumsButtonClick (view: View) {
        var inputText = ""

        when (view.id) {
            R.id.zero_button -> inputText = inputService.inputValidate("0", inputEditText.text.toString())
            R.id.one_button -> inputText = inputService.inputValidate("1", inputEditText.text.toString())
            R.id.two_button -> inputText = inputService.inputValidate("2", inputEditText.text.toString())
            R.id.three_button -> inputText = inputService.inputValidate("3", inputEditText.text.toString())
            R.id.four_button -> inputText = inputService.inputValidate("4", inputEditText.text.toString())
            R.id.five_button -> inputText = inputService.inputValidate("5", inputEditText.text.toString())
            R.id.six_button -> inputText = inputService.inputValidate("6", inputEditText.text.toString())
            R.id.seven_button -> inputText = inputService.inputValidate("7", inputEditText.text.toString())
            R.id.eight_button -> inputText = inputService.inputValidate("8", inputEditText.text.toString())
            R.id.nine_button -> inputText = inputService.inputValidate("9", inputEditText.text.toString())
        }

        inputEditText.setText(inputText)
    }
}