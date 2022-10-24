package rondarchik.calculator.converter.services

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import rondarchik.calculator.converter.R

class InputService(private var context: Context) : AppCompatActivity() {

    fun inputValidate(inputText: String, currentText: String): String {
        if (currentText.length >= 25) {
            Toast.makeText(context, R.string.to_much_toast, Toast.LENGTH_SHORT).show()
            return currentText
        }

        var fractionalPart = 0
        var fractionalFlag = false

        currentText.forEach {
            if (it == '.')
                fractionalFlag = true
            if (fractionalFlag)
                fractionalPart++
        }

        if (fractionalPart >= 15) {
            Toast.makeText(context, R.string.to_much_frac_toast, Toast.LENGTH_SHORT).show()
            return currentText
        }

        if (inputText[0] == '0') {
            var zeroFlag = true
            currentText.forEach {
                if (it != '0') {
                    zeroFlag = false
                    return@forEach
                }
            }
            if(zeroFlag)
                return "0"

            return currentText + inputText
        }
        else if (inputText == "." && currentText.length < 29) {
            var pointFlag = false
            currentText.forEach {
                if (it == '.') {
                    pointFlag = true
                    return@forEach
                }
            }
            if (pointFlag)
                return currentText

            return currentText + inputText
        }
        else if (inputText == ".")
            return currentText
        if (currentText == "0")
            return inputText
        return currentText + inputText
    }

}