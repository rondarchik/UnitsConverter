package rondarchik.calculator.converter


import android.content.ClipboardManager
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import rondarchik.calculator.converter.converters.Converter
import rondarchik.calculator.converter.databinding.ActivityMainBinding
import rondarchik.calculator.converter.services.IOService
import rondarchik.calculator.converter.services.InputService


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var clipboardManager: ClipboardManager

    private lateinit var inputService: InputService
    private lateinit var ioService: IOService
    private val converter = Converter()

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

        val inputEditText: EditText = findViewById(R.id.input_edittext)
        val outputEditText: EditText = findViewById(R.id. output_edittext)

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false
    }

    fun onNumsButtonClick (view: View) {
        val inputEditText: EditText = findViewById(R.id.input_edittext)
        val outputEditText: EditText = findViewById(R.id. output_edittext)
        val inputSpinner: Spinner = findViewById(R.id.input_spinner)
        val outputSpinner: Spinner = findViewById(R.id.output_spinner)

        when (view.id) {
            R.id.zero_button -> inputService.updateInputText("0", inputEditText)
            R.id.one_button -> inputService.updateInputText("1", inputEditText)
            R.id.two_button -> inputService.updateInputText("2", inputEditText)
            R.id.three_button -> inputService.updateInputText("3", inputEditText)
            R.id.four_button -> inputService.updateInputText("4", inputEditText)
            R.id.five_button -> inputService.updateInputText("5", inputEditText)
            R.id.six_button -> inputService.updateInputText("6", inputEditText)
            R.id.seven_button -> inputService.updateInputText("7", inputEditText)
            R.id.eight_button -> inputService.updateInputText("8", inputEditText)
            R.id.nine_button -> inputService.updateInputText("9", inputEditText)
            R.id.point_button -> inputService.updateInputText(".", inputEditText)
//            R.id.zero_button -> inputText = inputService.inputValidate("0", inputEditText.text.toString())
//            R.id.one_button -> inputText = inputService.inputValidate("1", inputEditText.text.toString())
//            R.id.two_button -> inputText = inputService.inputValidate("2", inputEditText.text.toString())
//            R.id.three_button -> inputText = inputService.inputValidate("3", inputEditText.text.toString())
//            R.id.four_button -> inputText = inputService.inputValidate("4", inputEditText.text.toString())
//            R.id.five_button -> inputText = inputService.inputValidate("5", inputEditText.text.toString())
//            R.id.six_button -> inputText = inputService.inputValidate("6", inputEditText.text.toString())
//            R.id.seven_button -> inputText = inputService.inputValidate("7", inputEditText.text.toString())
//            R.id.eight_button -> inputText = inputService.inputValidate("8", inputEditText.text.toString())
//            R.id.nine_button -> inputText = inputService.inputValidate("9", inputEditText.text.toString())
//            R.id.point_button -> inputText = inputService.inputValidate(".", inputEditText.text.toString())
            else -> inputEditText.text = inputEditText.text
        }

        converter.convert(inputEditText, outputEditText, inputSpinner, outputSpinner)
    }

    fun onKeyboardOtherButtonClick(view: View) {
        val inputEditText: EditText = findViewById(R.id.input_edittext)
        val outputEditText: EditText = findViewById(R.id. output_edittext)
        val inputSpinner: Spinner = findViewById(R.id.input_spinner)
        val outputSpinner: Spinner = findViewById(R.id.output_spinner)

        when (view.id) {
            R.id.empty -> Toast.makeText(applicationContext, R.string.empty, Toast.LENGTH_SHORT).show()
            R.id.clear_button -> inputService.clearAll(inputEditText, outputEditText)
            R.id.delete_button -> {
                inputService.deleteSymbol(inputEditText)
                converter.convert(inputEditText, outputEditText, inputSpinner, outputSpinner)
            }
        }
    }

    fun onIOButtonClick (view: View) {
        val inputCopyButton: ImageButton = findViewById(R.id.input_copy_button)
        val outputCopyButton: ImageButton = findViewById(R.id.output_copy_button)
        val inputPasteButton: ImageButton = findViewById(R.id.input_paste_button)
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
                    converter.convert(inputEditText, outputEditText, inputSpinner, outputSpinner)
                }
            R.id.exchange_button ->
                switchButton.setOnClickListener {
                    ioService.switchValues(inputEditText, outputEditText, inputSpinner, outputSpinner)
                }
        }
    }

    fun onInputClick(view: View)
    {
        val input: EditText = findViewById(R.id.input_edittext)

        input.setOnClickListener {
            //
        }
        input.setOnLongClickListener {
            ioService.pasteValue(input)
            converter.convert(input, findViewById(R.id.output_edittext),
                findViewById(R.id.input_spinner), findViewById(R.id.output_spinner))
            true
        }
    }

    fun onOutputClick(view: View) {
        val output: EditText = findViewById(R.id.output_edittext)

        output.setOnClickListener {
            Toast.makeText(this.applicationContext, R.string.edittext, Toast.LENGTH_LONG).show()
        }
        output.setOnLongClickListener {
            Toast.makeText(this.applicationContext, R.string.paste_edittext, Toast.LENGTH_LONG).show()
            true
        }
    }
}