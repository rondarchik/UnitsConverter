package rondarchik.calculator.converter.converters

import android.widget.EditText
import android.widget.Spinner
import rondarchik.calculator.converter.models.units.Units

class Converter {
    fun convert (inputValue: EditText, outputValue: EditText,
                 fromSpinner: Spinner, toSpinner: Spinner
    ) {

        var fromUnit = Units.M
        var toUnit = Units.M

        Units.values().forEach {
            if (it.nameOfUnit == fromSpinner.selectedItem.toString())
                fromUnit = it
            if (it.nameOfUnit == toSpinner.selectedItem.toString())
                toUnit = it
        }

        when (fromUnit) {
            Units.M, Units.KM, Units.FT, Units.MI -> lengthConvert(inputValue, outputValue, fromUnit, toUnit)
            Units.KG, Units.T, Units.LB, Units.OZ -> weightConvert(inputValue, outputValue, fromUnit, toUnit)
            Units.H, Units.Y, Units.D, Units.MIN -> timeConvert(inputValue, outputValue, fromUnit, toUnit)
        }
    }

    private fun lengthConvert (inputValue: EditText, outputValue: EditText,
                               fromUnit: Units, toUnit: Units) {

        val inputStr: String = inputValue.text.toString()
        val inputToNumber: Double = inputStr.toDouble()

        val lengthConverter = LengthConverter()

        when (fromUnit) {
            Units.M -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(inputStr)
                    Units.KM -> outputValue.setText(lengthConverter.metersToKilometers(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.FT -> outputValue.setText(lengthConverter.metersToFeet(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.MI -> outputValue.setText(lengthConverter.metersToMiles(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(inputStr)
                }
                return
            }
            Units.KM -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.metersToKilometers(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(inputStr)
                    Units.FT -> outputValue.setText(lengthConverter.kilometersToFeet(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.MI -> outputValue.setText(lengthConverter.kilometersToMiles(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(inputStr)
                }
                return
            }
            Units.FT -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.metersToFeet(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(lengthConverter.kilometersToFeet(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.FT -> outputValue.setText(inputStr)
                    Units.MI -> outputValue.setText(lengthConverter.feetToMiles(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(inputStr)
                }
                return
            }
            Units.MI -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.metersToMiles(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(lengthConverter.kilometersToMiles(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.FT -> outputValue.setText(lengthConverter.feetToMiles(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.MI -> outputValue.setText(inputStr)
                    else -> outputValue.setText(inputStr)
                }
                return
            }
            else -> {}
        }
    }

    private fun weightConvert (inputValue: EditText, outputValue: EditText,
                               fromUnit: Units, toUnit: Units) {

        val inputStr: String = inputValue.text.toString()
        val inputToNumber: Double = inputStr.toDouble()

        val weightConverter = WeightConverter()

        when (fromUnit) {
            Units.KG -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(inputStr)
                    Units.T -> outputValue.setText(weightConverter.kilogramsToTones(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.LB -> outputValue.setText(weightConverter.kilogramsToPounds(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.OZ -> outputValue.setText(weightConverter.kilogramsToOunces(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(inputStr)
                }
                return
            }
            Units.T -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.kilogramsToTones(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(inputStr)
                    Units.LB -> outputValue.setText(weightConverter.tonesToPounds(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.OZ -> outputValue.setText(weightConverter.tonesToOunces(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(inputStr)

                }
                return
            }
            Units.LB -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.kilogramsToPounds(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(weightConverter.tonesToPounds(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.LB -> outputValue.setText(inputStr)
                    Units.OZ -> outputValue.setText(weightConverter.poundsToOunces(inputToNumber)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(inputStr)

                }
                return
            }
            Units.OZ -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.kilogramsToOunces(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(weightConverter.tonesToOunces(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.LB -> outputValue.setText(weightConverter.poundsToOunces(inputToNumber, true)
                        .toBigDecimal().stripTrailingZeros().toPlainString())
                    Units.OZ -> outputValue.setText(inputStr)
                    else -> outputValue.setText(inputStr)

                }
                return
            }
            else -> {}
        }
    }

    private fun timeConvert (inputValue: EditText, outputValue: EditText,
                             fromUnit: Units, toUnit: Units) {

        val inputStr: String = inputValue.text.toString()
        val inputToNumber: Double = inputStr.toDouble()

        val timeConverter = TimeConverter()

        when (fromUnit) {
            Units.H -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(inputStr)
                    Units.MIN -> outputValue.setText(
                        timeConverter.hoursToMinutes(inputToNumber)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.D -> outputValue.setText(
                        timeConverter.hoursToDays(inputToNumber)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.Y -> outputValue.setText(
                        timeConverter.hoursToYears(inputToNumber)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    else -> outputValue.setText(inputStr)

                }
                return
            }
            Units.MIN -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(
                        timeConverter.hoursToMinutes(inputToNumber, true)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.MIN -> outputValue.setText(inputStr)
                    Units.D -> outputValue.setText(
                        timeConverter.minutesToDays(inputToNumber)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.Y -> outputValue.setText(
                        timeConverter.minutesToYears(inputToNumber)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    else -> outputValue.setText(inputStr)

                }
                return
            }
            Units.D -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(
                        timeConverter.hoursToDays(inputToNumber, true)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.MIN -> outputValue.setText(
                        timeConverter.minutesToDays(inputToNumber, true)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.D -> outputValue.setText(inputStr)
                    Units.Y -> outputValue.setText(
                        timeConverter.daysToYears(inputToNumber)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    else -> outputValue.setText(inputStr)
                }
                return
            }
            Units.Y -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(
                        timeConverter.hoursToYears(inputToNumber, true)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.MIN -> outputValue.setText(
                        timeConverter.minutesToYears(inputToNumber, true)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.D -> outputValue.setText(
                        timeConverter.daysToYears(inputToNumber, true)
                            .toBigDecimal().stripTrailingZeros().toPlainString()
                    )
                    Units.Y -> outputValue.setText(inputStr)
                    else -> outputValue.setText(inputStr)
                }
                return
            }
            else -> {}
        }
    }
}