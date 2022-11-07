package rondarchik.calculator.converter.services

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import rondarchik.calculator.converter.R

class IOService(private var context: Context, private var clipboardManager: ClipboardManager) {

    private lateinit var clipData: ClipData

    fun switchValues(inputEditText: EditText, outputEditText: EditText,
                     inputSpinner: Spinner, outputSpinner: Spinner): Int{

        if (inputEditText.length() == 0) {
            Toast.makeText(context, "Нечего свапать! Введи хотя бы одно чиселко", Toast.LENGTH_SHORT).show()
            return 0
        }

        val inputStr = inputEditText.text.toString().toBigDecimal()
        val outputStr = outputEditText.text.toString().toBigDecimal()
        val inputSpinnerId = inputSpinner.selectedItemId.toInt()
        val outputSpinnerId = outputSpinner.selectedItemId.toInt()

        if (inputSpinnerId == outputSpinnerId) {
            Toast.makeText(context, "Ну типо ничего не изменилось\nЕдиницы измерения одни и те же", Toast.LENGTH_SHORT).show()
            return inputEditText.length()
        }

        inputSpinner.setSelection(outputSpinnerId, true)
        outputSpinner.setSelection(inputSpinnerId, true)

        inputEditText.setText(outputStr.stripTrailingZeros().toPlainString())
        outputEditText.setText(inputStr.stripTrailingZeros().toPlainString())

        return inputEditText.length()
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

        val res = oldStr + strToPaste

        val pointCounter = strToPaste.count { it == '.' }

        val pointCounter2 = res.count {it == '.'}

        if (pointCounter > 1) {
            Toast.makeText(context, R.string.to_much_points_to_paste, Toast.LENGTH_SHORT).show()
            return
        }

        if (pointCounter2 > 1) {
            Toast.makeText(context, R.string.to_much_points_to_paste, Toast.LENGTH_SHORT).show()
            return
        }

        if (oldStr.length + strToPaste.length > 50) {
            Toast.makeText(context, R.string.to_much_to_paste, Toast.LENGTH_SHORT).show()
            return
        }

        for (i in strToPaste) {
            if (i !in correctCharacters) {
                Toast.makeText(context, R.string.no_digits_to_paste, Toast.LENGTH_SHORT).show()
                return
            }
        }

        fieldToPaste.text = String.format("%s%s%s", leftStrPart, strToPaste, rightStrPart)
        Toast.makeText(context, R.string.paste_message, Toast.LENGTH_SHORT).show()
    }
}