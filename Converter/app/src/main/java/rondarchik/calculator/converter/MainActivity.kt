package rondarchik.calculator.converter


import android.content.ClipboardManager
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import rondarchik.calculator.converter.databinding.ActivityMainBinding
import rondarchik.calculator.converter.services.IOService
import rondarchik.calculator.converter.services.InputService
import rondarchik.calculator.converter.services.SpinnerOnItemSelectedListener
import rondarchik.calculator.converter.ui.length.LengthViewModel
import rondarchik.calculator.converter.ui.time.TimeViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var clipboardManager: ClipboardManager

    private lateinit var inputService: InputService
    private lateinit var ioService: IOService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    }

    override fun onStart() {
        super.onStart()

        this.inputService = InputService(this.applicationContext)
        this.ioService = IOService(this.applicationContext, clipboardManager)

        //val spinnerListener = SpinnerOnItemSelectedListener()
    }

    fun onNumsButtonClick (view: View) {
        var inputText = ""
        val inputEditText: EditText = findViewById(R.id.input_edittext)

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

    fun onIOButtonClick (view: View) {
        val inputCopyButton: ImageButton = findViewById(R.id.input_copy_button)
        val outputCopyButton: ImageButton = findViewById(R.id.output_copy_button)
        val inputPasteButton: ImageButton = findViewById(R.id.input_paste_button)
        val outputPasteButton: ImageButton = findViewById(R.id.output_paste_button)
        val switchButton: ImageButton = findViewById(R.id.exchange_button)
        val inputEditText: EditText = findViewById(R.id.input_edittext)
        val outputEditText: EditText = findViewById(R.id.output_edittext)
        val inputSpinner: Spinner = findViewById(R.id.input_spinner)
        val outputSpinner: Spinner = findViewById(R.id.output_spinner)

        when (view.id) {
            R.id.input_copy_button ->
                inputCopyButton.setOnClickListener {
                    ioService.copyValue(inputEditText)
                }
            R.id.output_copy_button ->
                outputCopyButton.setOnClickListener {
                    ioService.copyValue(outputEditText)
                }
            R.id.input_paste_button ->
                inputPasteButton.setOnClickListener {
                    ioService.pasteValue(inputEditText)
                }
            R.id.output_paste_button ->
                outputPasteButton.setOnClickListener {
                    ioService.pasteValue(outputEditText)
                }
            R.id.exchange_button ->
                switchButton.setOnClickListener {
                    ioService.switchValues(inputEditText, outputEditText, inputSpinner, outputSpinner)
                }
        }
    }

    private fun changeSpinnerList(itemId: Int): Boolean {
        val inputSpinner: Spinner = findViewById(R.id.input_spinner)
        val outputSpinner: Spinner = findViewById(R.id.output_spinner)

        val adapter = when (itemId) {
            0 -> ArrayAdapter.createFromResource(this.applicationContext, R.array.length_list, R.layout.layout_spinner)
            1 -> ArrayAdapter.createFromResource(this.applicationContext, R.array.weight_list, R.layout.layout_spinner)
            2 -> ArrayAdapter.createFromResource(this.applicationContext, R.array.time_list, R.layout.layout_spinner)
            else -> return false
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        inputSpinner.adapter = adapter
        outputSpinner.adapter = adapter

        return true
    }
}