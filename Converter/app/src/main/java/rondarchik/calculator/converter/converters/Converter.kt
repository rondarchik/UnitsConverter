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

        val input = inputValue.text.toString().toBigDecimal()

        val lengthConverter = LengthConverter()

        when (fromUnit) {
            Units.M -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(lengthConverter.metersToKilometers(input)
                        .stripTrailingZeros().toPlainString())
                    Units.FT -> outputValue.setText(lengthConverter.metersToFeet(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MI -> outputValue.setText(lengthConverter.metersToMiles(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.KM -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.metersToKilometers(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.FT -> outputValue.setText(lengthConverter.kilometersToFeet(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MI -> outputValue.setText(lengthConverter.kilometersToMiles(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.FT -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.metersToFeet(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(lengthConverter.kilometersToFeet(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.FT -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.MI -> outputValue.setText(lengthConverter.feetToMiles(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.MI -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.metersToMiles(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(lengthConverter.kilometersToMiles(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.FT -> outputValue.setText(lengthConverter.feetToMiles(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.MI -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            else -> {}
        }
    }

    private fun weightConvert (inputValue: EditText, outputValue: EditText,
                               fromUnit: Units, toUnit: Units) {

        val input = inputValue.text.toString().toBigDecimal()

        val weightConverter = WeightConverter()

        when (fromUnit) {
            Units.KG -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(weightConverter.kilogramsToTones(input)
                        .stripTrailingZeros().toPlainString())
                    Units.LB -> outputValue.setText(weightConverter.kilogramsToPounds(input)
                        .stripTrailingZeros().toPlainString())
                    Units.OZ -> outputValue.setText(weightConverter.kilogramsToOunces(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.T -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.kilogramsToTones(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.LB -> outputValue.setText(weightConverter.tonesToPounds(input)
                        .stripTrailingZeros().toPlainString())
                    Units.OZ -> outputValue.setText(weightConverter.tonesToOunces(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.LB -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.kilogramsToPounds(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(weightConverter.tonesToPounds(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.LB -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.OZ -> outputValue.setText(weightConverter.poundsToOunces(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.OZ -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.kilogramsToOunces(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(weightConverter.tonesToOunces(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.LB -> outputValue.setText(weightConverter.poundsToOunces(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.OZ -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            else -> {}
        }
    }

    private fun timeConvert (inputValue: EditText, outputValue: EditText,
                             fromUnit: Units, toUnit: Units) {

        val input = inputValue.text.toString().toBigDecimal()

        val timeConverter = TimeConverter()

        when (fromUnit) {
            Units.H -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.MIN -> outputValue.setText(timeConverter.hoursToMinutes(input)
                        .stripTrailingZeros().toPlainString())
                    Units.D -> outputValue.setText(timeConverter.hoursToDays(input)
                        .stripTrailingZeros().toPlainString())
                    Units.Y -> outputValue.setText(timeConverter.hoursToYears(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.MIN -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(timeConverter.hoursToMinutes(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.MIN -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.D -> outputValue.setText(timeConverter.minutesToDays(input)
                        .stripTrailingZeros().toPlainString())
                    Units.Y -> outputValue.setText(timeConverter.minutesToYears(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.D -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(timeConverter.hoursToDays(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.MIN -> outputValue.setText(timeConverter.minutesToDays(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.D -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.Y -> outputValue.setText(timeConverter.daysToYears(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.Y -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(timeConverter.hoursToYears(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.MIN -> outputValue.setText(timeConverter.minutesToYears(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.D -> outputValue.setText(timeConverter.daysToYears(input, true)
                        .stripTrailingZeros().toPlainString())
                    Units.Y -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            else -> {}
        }
    }
}