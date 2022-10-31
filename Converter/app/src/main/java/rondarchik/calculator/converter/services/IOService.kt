package rondarchik.calculator.converter.services

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import rondarchik.calculator.converter.R

class IOService(private var context: Context, var clipboardManager: ClipboardManager) {

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

        val strToPaste = item.text.toString()
        val correctCharacters = "0123456789."

        if (strToPaste.length >= 25) {
            Toast.makeText(context, R.string.to_much_to_paste, Toast.LENGTH_LONG).show()
            return
        }

        for (i in strToPaste) {
            if (i !in correctCharacters) {
                Toast.makeText(context, R.string.no_digits_to_paste, Toast.LENGTH_LONG).show()
                return
            }
        }

        fieldToPaste.text = strToPaste
        Toast.makeText(context, R.string.paste_message, Toast.LENGTH_SHORT).show()
    }
}