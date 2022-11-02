package rondarchik.calculator.converter.services

import android.content.Context
import android.text.SpannableStringBuilder
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import rondarchik.calculator.converter.R

class InputService(private var context: Context) : AppCompatActivity() {

    fun updateInputText(strToAdd: String, inputEditText: EditText, outputText: EditText) {
        // cursor
        val oldStr = inputEditText.text.toString()
        val cursorPosition = inputEditText.selectionStart
//        if (strToAdd == ".")
//            inputEditText.setSelection(cursorPosition + 1)
        val leftStrPart = oldStr.substring(0, cursorPosition)
        val rightStrPart = oldStr.substring(cursorPosition)
        val beforePointPart = oldStr.substringBefore('.')
        var zeroIsFirst = false
        val newString: String
        // point validate
        var fractionalPartCounter = 0
        var fractionalFlag = false
        var pointFlag = false
        // zero validate
        var zeroFlag = true

        if (oldStr[0] == '0')
            zeroIsFirst = true

        if (oldStr.length >= 20) {
            Toast.makeText(context, R.string.to_much_toast, Toast.LENGTH_SHORT).show()
            inputEditText.setText(oldStr)
            inputEditText.setSelection(cursorPosition)
            return
        }

        if (cursorPosition < beforePointPart.length) {
            if (strToAdd == "0" && zeroIsFirst && cursorPosition == 0) {
                Toast.makeText(context, R.string.zero2, Toast.LENGTH_LONG).show()
                inputEditText.setText(oldStr)
                inputEditText.setSelection(cursorPosition)
                return
            }
        }

        if (cursorPosition == oldStr.length && oldStr == "0" && strToAdd == "0") {
            Toast.makeText(context, R.string.zero2, Toast.LENGTH_LONG).show()
            inputEditText.setText(oldStr)
            inputEditText.setSelection(cursorPosition)
            return
        }

        if (outputText.text.toString().length == 20) {
            Toast.makeText(context, R.string.stop, Toast.LENGTH_LONG).show()
            inputEditText.setText(oldStr + strToAdd)
            inputEditText.setSelection(cursorPosition + 1)
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

        if (strToAdd == "." && oldStr == "0" && cursorPosition == oldStr.length) {
            newString = leftStrPart + strToAdd + rightStrPart
            inputEditText.setText(newString)
            inputEditText.setSelection(cursorPosition + 1)
            return
        }
        else if (strToAdd == "." && oldStr == "0") {
            newString = oldStr + strToAdd
            inputEditText.setText(newString)
            inputEditText.setSelection(cursorPosition + 2)
            return
        }
        else if (oldStr == "0" && (strToAdd != "." || strToAdd != "0") && cursorPosition == 1) {
            inputEditText.setText(strToAdd)
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

        if (oldStr.length == 15 && !pointFlag) {
            Toast.makeText(context, R.string.max_integer, Toast.LENGTH_LONG).show()
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
        if (inputText.text.toString() == "0") {
            Toast.makeText(context, R.string.nothing, Toast.LENGTH_SHORT).show()
        }
        inputText.setText("0")
        outputText.setText("0")
    }

    fun deleteSymbol(inputText: EditText, outputText: EditText) {
        val inputStr = inputText.text.toString()
        val cursorPos = inputText.selectionStart

        if (inputText.text.toString() == "0") {
            Toast.makeText(context, R.string.nothing, Toast.LENGTH_SHORT).show()
            inputText.setText(inputText.text.toString())
            return
        }
        else if (inputText.text.toString() != "0" && cursorPos == 0) {
            Toast.makeText(context, R.string.nothing, Toast.LENGTH_SHORT).show()
            inputText.setText(inputText.text.toString())
            return
        }

        if (cursorPos != 0 && inputStr != "0" && inputStr.length != 1) {
            val selector: SpannableStringBuilder = inputText.text as SpannableStringBuilder
            selector.replace(cursorPos - 1, cursorPos, "")
            inputText.text = selector
            inputText.setSelection(cursorPos - 1)
            return
        }
        else {
            inputText.setText("0")
            outputText.setText("0")
            return
        }
    }
}