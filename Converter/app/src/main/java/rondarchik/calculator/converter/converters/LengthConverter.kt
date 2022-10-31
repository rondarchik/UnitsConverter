package rondarchik.calculator.converter.converters

import android.widget.EditText
import android.widget.Spinner
import rondarchik.calculator.converter.models.LengthModel
import rondarchik.calculator.converter.models.units.LengthUnits

class LengthConverter {

    private val lengthModel = LengthModel()

    private fun metersToKilometers(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.metersToKilometers
        else
            value / lengthModel.metersToKilometers
    }

    private fun metersToFeet(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.metersToFeet
        else
            value / lengthModel.metersToFeet
    }

    private fun metersToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.metersToMiles
        else
            value / lengthModel.metersToMiles
    }

    private fun kilometersToFeet(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.kilometersToFeet
        else
            value / lengthModel.kilometersToFeet
    }

    private fun kilometersToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.kilometersToMiles
        else
            value / lengthModel.kilometersToMiles
    }

    private fun feetToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.feetToMiles
        else
            value / lengthModel.feetToMiles
    }

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

    private fun lengthConvert (inputValue: EditText, outputValue: EditText,
                       fromUnit: LengthUnits, toUnit: LengthUnits
    ) {
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
}