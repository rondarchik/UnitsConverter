package rondarchik.calculator.converter.services

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RestrictTo
import rondarchik.calculator.converter.R
import java.util.Locale.filter

class IOService(private var context: Context, private var clipboardManager: ClipboardManager) {

    private lateinit var clipData: ClipData

    fun switchValues(inputEditText: EditText, outputEditText: EditText,
                     inputSpinner: Spinner, outputSpinner: Spinner) {
        val inputStr = inputEditText.text.toString()
        val inputSpinnerId = inputSpinner.selectedItemId.toInt()

        inputEditText.setText(outputEditText.text.toString())
        outputEditText.setText(inputStr)

        inputSpinner.setSelection(outputSpinner.selectedItemId.toInt(), true)
        outputSpinner.setSelection(inputSpinnerId, true)
    }

    fun copyValue(fieldToCopy: TextView) {
        val str: String = fieldToCopy.text.toString()

        clipData = ClipData.newPlainText("text", str)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(context, R.string.copy_message, Toast.LENGTH_SHORT).show()
    }

    fun pasteValue(fieldToPaste: TextView) {
        val data = clipboardManager.primaryClip as ClipData
        val item: ClipData.Item = data.getItemAt(0)

        val oldStr = fieldToPaste.text.toString()
        val cursorPosition = fieldToPaste.selectionStart
        val leftStrPart = oldStr.substring(0, cursorPosition)
        val rightStrPart = oldStr.substring(cursorPosition)

        val strToPaste = item.text.toString()
        val correctCharacters = "0123456789."

        var pointCounter = strToPaste.count { it == '.' }
        var fractionalFlag = false
        var fractionalPartCounter = 0
        var beforePointPart = strToPaste.substringBefore('.')
        var zeroCounter = beforePointPart.count { it == '0' }

        if (pointCounter > 1) {
            Toast.makeText(context, R.string.to_much_points_to_paste, Toast.LENGTH_LONG).show()
            return
        }

        if (oldStr.length + strToPaste.length >= 20) {
            Toast.makeText(context, R.string.to_much_to_paste, Toast.LENGTH_LONG).show()
            return
        }

        for (i in strToPaste) {
            if (i !in correctCharacters) {
                Toast.makeText(context, R.string.no_digits_to_paste, Toast.LENGTH_LONG).show()
                return
            }
        }

        if (zeroCounter > 1 && pointCounter != 0) {
            Toast.makeText(context, R.string.to_much_zeros_to_paste, Toast.LENGTH_LONG).show()
            return
        }

        strToPaste.forEach {
            if (it == '.') {
                fractionalFlag = true
            }
            if (fractionalFlag) {
                fractionalPartCounter++
            }
        }

        if (fractionalPartCounter > 10) {
            Toast.makeText(context, R.string.to_much_frac_to_paste, Toast.LENGTH_SHORT).show()
            return
        }

        fieldToPaste.text = leftStrPart + strToPaste + rightStrPart
        Toast.makeText(context, R.string.paste_message, Toast.LENGTH_SHORT).show()
    }
}