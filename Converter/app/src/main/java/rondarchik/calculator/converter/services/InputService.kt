package rondarchik.calculator.converter.services

import android.content.Context
import android.text.SpannableStringBuilder
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import rondarchik.calculator.converter.R

class InputService(private var context: Context) : AppCompatActivity() {

    fun updateInputText(strToAdd: String, inputEditText: EditText) {
        // cursor
        val oldStr = inputEditText.text.toString()
        val cursorPosition = inputEditText.selectionStart
        val leftStrPart = oldStr.substring(0, cursorPosition)
        val rightStrPart = oldStr.substring(cursorPosition)
        // point validate
        var pointFlag = false

//        if (oldStr.length >= 50) {
//            Toast.makeText(context, R.string.to_much_toast, Toast.LENGTH_SHORT).show()
//            inputEditText.setText(oldStr)
//            inputEditText.setSelection(cursorPosition)
//            return
//        }

        if (strToAdd == "." && oldStr.length < 49) {
            oldStr.forEach {
                if (it == '.') {
                    pointFlag = true
                    return@forEach
                }
            }
            if (pointFlag) {
                Toast.makeText(context, R.string.point2, Toast.LENGTH_SHORT).show()
                inputEditText.setText(oldStr)
                inputEditText.setSelection(cursorPosition)
                return
            }
            inputEditText.setText(String.format("%s%s%s", leftStrPart, strToAdd, rightStrPart))
            inputEditText.setSelection(cursorPosition + 1)
            return
        }
//        else if (strToAdd == ".") {
//            Toast.makeText(context, R.string.point_, Toast.LENGTH_SHORT).show()
//            inputEditText.setText(oldStr)
//            inputEditText.setSelection(cursorPosition)
//            return
//        }

        if (oldStr.isEmpty()) {
            inputEditText.setText(strToAdd)
            inputEditText.setSelection(cursorPosition + 1)
            return
        }

        inputEditText.setText(String.format("%s%s%s", leftStrPart, strToAdd, rightStrPart))
        inputEditText.setSelection(cursorPosition + 1)
        return
    }

    fun clearAll(inputText: EditText, outputText: EditText) {
        if (inputText.length() == 0) {
            Toast.makeText(context, R.string.nothing, Toast.LENGTH_SHORT).show()
        }
        inputText.text.clear()
        outputText.text.clear()
    }

    fun deleteSymbol(inputText: EditText, outputText: EditText) {
        val inputStr = inputText.text.toString()
        val cursorPos = inputText.selectionStart

        if (inputText.length() == 0) {
            Toast.makeText(context, R.string.nothing, Toast.LENGTH_SHORT).show()
            inputText.setText(inputText.text.toString())
            return
        }
        else if (cursorPos == 0) {
            Toast.makeText(context, R.string.nothing, Toast.LENGTH_SHORT).show()
            inputText.setText(inputText.text.toString())
            return
        }

        if (cursorPos != 0 && inputStr.isNotEmpty() && inputStr.length != 1) {
            val selector: SpannableStringBuilder = inputText.text as SpannableStringBuilder
            selector.replace(cursorPos - 1, cursorPos, "")
            inputText.text = selector
            inputText.setSelection(cursorPos - 1)
            return
        }
        else {
            inputText.text.clear()
            outputText.text.clear()
            return
        }
    }
}