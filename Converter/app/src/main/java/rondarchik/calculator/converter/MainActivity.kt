package rondarchik.calculator.converter


import android.content.ClipboardManager
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
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

        val inputEditText: EditText = findViewById(R.id.input_edittext)
        val outputEditText: EditText = findViewById(R.id. output_edittext)

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false

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
    }

    fun onNumsButtonClick (view: View) {
        val inputEditText: EditText = findViewById(R.id.input_edittext)
        val outputEditText: EditText = findViewById(R.id. output_edittext)
        val inputSpinner: Spinner = findViewById(R.id.input_spinner)
        val outputSpinner: Spinner = findViewById(R.id.output_spinner)

        when (view.id) {
            R.id.zero_button -> inputService.updateInputText("0", inputEditText, outputEditText)
            R.id.one_button -> inputService.updateInputText("1", inputEditText, outputEditText)
            R.id.two_button -> inputService.updateInputText("2", inputEditText, outputEditText)
            R.id.three_button -> inputService.updateInputText("3", inputEditText, outputEditText)
            R.id.four_button -> inputService.updateInputText("4", inputEditText, outputEditText)
            R.id.five_button -> inputService.updateInputText("5", inputEditText, outputEditText)
            R.id.six_button -> inputService.updateInputText("6", inputEditText, outputEditText)
            R.id.seven_button -> inputService.updateInputText("7", inputEditText, outputEditText)
            R.id.eight_button -> inputService.updateInputText("8", inputEditText, outputEditText)
            R.id.nine_button -> inputService.updateInputText("9", inputEditText, outputEditText)
            R.id.point_button -> inputService.updateInputText(".", inputEditText, outputEditText)
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
                inputService.deleteSymbol(inputEditText, outputEditText)
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
                    inputEditText.setSelection(inputEditText.text.toString().length)
                    converter.convert(inputEditText, outputEditText, inputSpinner, outputSpinner)
                }
            R.id.exchange_button ->
                switchButton.setOnClickListener {
                    ioService.switchValues(inputEditText, outputEditText, inputSpinner, outputSpinner)
                }
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