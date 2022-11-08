package rondarchik.calculator.converter


import android.content.ClipboardManager
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
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
        val cursor: TextView = findViewById(R.id.cursorPositionText)
        cursor.text = "Cursor position: ${inputEditText.selectionStart} / ${inputEditText.length()}"

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
        val cursor: TextView = findViewById(R.id.cursorPositionText)
        cursor.text = "Cursor position: ${inputEditText.selectionStart} / ${inputEditText.length()}"

        inputEditText.showSoftInputOnFocus = false
        outputEditText.showSoftInputOnFocus = false

        inputEditText.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                Toast.makeText(applicationContext, R.string.no_select, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                Toast.makeText(applicationContext, R.string.no_select, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                Toast.makeText(applicationContext, R.string.no_select, Toast.LENGTH_SHORT).show()
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
            else -> inputEditText.text = inputEditText.text
        }

        converter.convert(inputEditText, outputEditText, inputSpinner, outputSpinner)
        val cursor: TextView = findViewById(R.id.cursorPositionText)
        cursor.text = "Cursor position: ${inputEditText.selectionStart} / ${inputEditText.length()}"
    }

    fun onKeyboardOtherButtonClick(view: View) {
        val inputEditText: EditText = findViewById(R.id.input_edittext)
        val outputEditText: EditText = findViewById(R.id. output_edittext)
        val inputSpinner: Spinner = findViewById(R.id.input_spinner)
        val outputSpinner: Spinner = findViewById(R.id.output_spinner)

        when (view.id) {
            R.id.empty -> {
                Toast.makeText(applicationContext, R.string.empty, Toast.LENGTH_SHORT).show()
            }
            R.id.clear_button -> inputService.clearAll(inputEditText, outputEditText)
            R.id.delete_button -> {
                inputService.deleteSymbol(inputEditText, outputEditText)
                converter.convert(inputEditText, outputEditText, inputSpinner, outputSpinner)
            }
        }

        val cursor: TextView = findViewById(R.id.cursorPositionText)
        cursor.text = "Cursor position: ${inputEditText.selectionStart} / ${inputEditText.length()}"
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

        val cursor: TextView = findViewById(R.id.cursorPositionText)

        when (view.id) {
            R.id.cursorBackButton -> {
                val cursorPos = inputEditText.selectionStart
                if (cursorPos == 0) {
                    Toast.makeText(this.applicationContext, R.string.back, Toast.LENGTH_SHORT).show()
                    return
                }
                inputEditText.setSelection(cursorPos - 1)
                cursor.text = "Cursor position: ${cursorPos - 1} / ${inputEditText.length()}"
            }
            R.id.cursorForwardButton -> {
                val cursorPos = inputEditText.selectionStart
                if (cursorPos == inputEditText.length()) {
                    Toast.makeText(this.applicationContext, R.string.forward, Toast.LENGTH_SHORT).show()
                    return
                }
                inputEditText.setSelection(cursorPos + 1)
                cursor.text = "Cursor position: ${cursorPos + 1} / ${inputEditText.length()}"
            }
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
                    val length = ioService.pasteValue(inputEditText)
                    converter.convert(inputEditText, outputEditText, inputSpinner, outputSpinner)

                    inputEditText.setSelection(length)
                    cursor.text = "Cursor position: $length / ${inputEditText.length()}"
                }
            R.id.exchange_button -> {
                switchButton.setOnClickListener {
                    val length = ioService.switchValues(
                        inputEditText,
                        outputEditText,
                        inputSpinner,
                        outputSpinner
                    )

                    inputEditText.setSelection(inputEditText.length())
                    cursor.text = "Cursor position: ${inputEditText.selectionStart} / $length"
                }
            }
        }
    }

    fun onOutputClick(view: View) {
        val output: EditText = findViewById(R.id.output_edittext)

        output.setOnClickListener {
            Toast.makeText(this.applicationContext, R.string.edittext, Toast.LENGTH_SHORT).show()
        }
        output.setOnLongClickListener {
            Toast.makeText(this.applicationContext, R.string.paste_edittext, Toast.LENGTH_SHORT).show()
            true
        }
    }

    fun onInputClick(view: View) {
        val input: EditText = findViewById(R.id.input_edittext)

        input.setOnClickListener {
            Toast.makeText(this.applicationContext, R.string.input_edittext, Toast.LENGTH_SHORT).show()
        }
        input.setOnLongClickListener {
            Toast.makeText(this.applicationContext, R.string.input_paste_edittext, Toast.LENGTH_SHORT).show()
            true
        }
    }

}