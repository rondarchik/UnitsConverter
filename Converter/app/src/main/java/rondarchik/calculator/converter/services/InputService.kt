package rondarchik.calculator.converter.services

import android.content.Context
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
        val newString: String
        // point validate
        var fractionalPartCounter = 0
        var fractionalFlag = false
        var pointFlag = false
        // zero validate
        var zeroFlag = true

        if (oldStr.length > 20) {
            Toast.makeText(context, R.string.to_much_toast, Toast.LENGTH_SHORT).show()
            inputEditText.setText(oldStr)
            inputEditText.setSelection(cursorPosition)
            return
        }

        oldStr.forEach {
            if (it == '.') {
                fractionalFlag = true
            }
            if (fractionalFlag)
                fractionalPartCounter++
        }

        if (fractionalPartCounter > 10) {
            Toast.makeText(context, R.string.to_much_frac_toast, Toast.LENGTH_SHORT).show()
            inputEditText.setText(oldStr)
            inputEditText.setSelection(cursorPosition)
            return
        }

        if (strToAdd == "0") {
            oldStr.forEach {
                if (it != '0') {
                    zeroFlag = false
                    return@forEach
                }
            }

            if (zeroFlag) {
                inputEditText.setText("0")
                inputEditText.setSelection(cursorPosition + 1)
                Toast.makeText(context, R.string.zero2, Toast.LENGTH_SHORT).show()
                return
            }
            else {
                newString = leftStrPart + strToAdd + rightStrPart
                inputEditText.setText(newString)
                inputEditText.setSelection(cursorPosition + 1)
                return
            }
        }
        else if (strToAdd == "." && oldStr.length < 20) {
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
            else {
                newString = leftStrPart + strToAdd + rightStrPart
                inputEditText.setText(newString)
                inputEditText.setSelection(cursorPosition + 1)
                return
            }
        }
        else if (strToAdd == "." && oldStr.length == 19) {
            Toast.makeText(context, R.string.point_, Toast.LENGTH_LONG).show()
            inputEditText.setText(oldStr)
            inputEditText.setSelection(cursorPosition)
            return
        }

        if (oldStr == "0") {
            inputEditText.setText(strToAdd)
            inputEditText.setSelection(cursorPosition + 1)
            return
        }
        else {
            newString = leftStrPart + strToAdd + rightStrPart
            inputEditText.setText(newString)
            inputEditText.setSelection(cursorPosition + 1)
            return
        }
    }

    fun clearAll(inputText: EditText, outputText: EditText) {
        inputText.setText("0")
        outputText.setText("0")
    }

    fun deleteSymbol(inputText: EditText) {
        var inputStr = inputText.text.toString()

        if (inputStr.length == 1)
            inputText.setText("0")
        else {
            inputStr = inputStr.dropLast(1)
            inputText.setText(inputStr)
        }
    }
}