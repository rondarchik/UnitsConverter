package rondarchik.calculator.converter.converters

import android.widget.EditText
import android.widget.Spinner
import rondarchik.calculator.converter.models.units.LengthUnits

class Converter {

    fun convert (inputValue: EditText, outputValue: EditText,
                 fromSpinner: Spinner, toSpinner: Spinner) {
        var fromLengthUnits = LengthUnits.M
        var toLengthUnits = LengthUnits.M

        LengthUnits.values().forEach {
            if (it.nameOfUnit == fromSpinner.selectedItem.toString())
                fromLengthUnits = it
            if (it.nameOfUnit == toSpinner.selectedItem.toString())
                toLengthUnits = it

            lengthConvert(inputValue, outputValue, fromLengthUnits, toLengthUnits)
        }
    }

    fun lengthConvert (inputValue: EditText, outputValue: EditText,
                       fromUnit: LengthUnits, toUnit: LengthUnits) {
        val inputStr: String = inputValue.text.toString()
        val inputToNumber: Double = inputStr.toDouble()

        val lengthConverter = LengthConverter()

        when (fromUnit) {
            LengthUnits.M -> {
                when (toUnit) {
                    LengthUnits.M -> outputValue.setText(inputStr)
                    LengthUnits.KM -> outputValue.setText(lengthConverter.metersToKilometers(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.FT -> outputValue.setText(lengthConverter.metersToFeet(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.MI -> outputValue.setText(lengthConverter.metersToMiles(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                }
                return
            }
            LengthUnits.KM -> {
                when (toUnit) {
                    LengthUnits.M -> outputValue.setText(lengthConverter.metersToKilometers(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.KM -> outputValue.setText(inputStr)
                    LengthUnits.FT -> outputValue.setText(lengthConverter.kilometersToFeet(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.MI -> outputValue.setText(lengthConverter.kilometersToMiles(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                }
                return
            }
            LengthUnits.FT -> {
                when (toUnit) {
                    LengthUnits.M -> outputValue.setText(lengthConverter.metersToFeet(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.KM -> outputValue.setText(lengthConverter.kilometersToFeet(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.FT -> outputValue.setText(inputStr)
                    LengthUnits.MI -> outputValue.setText(lengthConverter.feetToMiles(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                }
                return
            }
            LengthUnits.MI -> {
                when (toUnit) {
                    LengthUnits.M -> outputValue.setText(lengthConverter.metersToMiles(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.KM -> outputValue.setText(lengthConverter.kilometersToMiles(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.FT -> outputValue.setText(lengthConverter.feetToMiles(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    LengthUnits.MI -> outputValue.setText(inputStr)
                }
                return
            }
        }
    }

    fun weightConvert () {
        TODO("because")
    }

    fun timeConvert () {
        TODO("because")
    }
}