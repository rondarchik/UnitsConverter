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
        fieldToPaste.text = strToPaste
        Toast.makeText(context, R.string.paste_message, Toast.LENGTH_SHORT).show()
    }
}