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
            Units.M, Units.KM, Units.CM, Units.MM -> lengthConvert(inputValue, outputValue, fromUnit, toUnit)
            Units.KG, Units.T, Units.Q, Units.G -> weightConvert(inputValue, outputValue, fromUnit, toUnit)
            Units.H, Units.SEC, Units.D, Units.MIN -> timeConvert(inputValue, outputValue, fromUnit, toUnit)
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
                    Units.CM -> outputValue.setText(lengthConverter.metersToCentimeters(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MM -> outputValue.setText(lengthConverter.metersToMillimeters(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.KM -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.kilometersToMeters(input)
                        .stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.CM -> outputValue.setText(lengthConverter.kilometersToCm(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MM -> outputValue.setText(lengthConverter.kilometersToMm(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.CM -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.centimetersToMeters(input)
                        .stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(lengthConverter.cmToKilometers(input)
                        .stripTrailingZeros().toPlainString())
                    Units.CM -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.MM -> outputValue.setText(lengthConverter.cmToMM(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.MM -> {
                when (toUnit) {
                    Units.M -> outputValue.setText(lengthConverter.mmToMeters(input)
                        .stripTrailingZeros().toPlainString())
                    Units.KM -> outputValue.setText(lengthConverter.mmToKilometers(input)
                        .stripTrailingZeros().toPlainString())
                    Units.CM -> outputValue.setText(lengthConverter.mmTOCm(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MM -> outputValue.setText(input.stripTrailingZeros().toPlainString())
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
                    Units.Q -> outputValue.setText(weightConverter.kilogramsToQuintals(input)
                        .stripTrailingZeros().toPlainString())
                    Units.G -> outputValue.setText(weightConverter.kilogramsToGrams(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.T -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.tonesToKg(input)
                        .stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.Q -> outputValue.setText(weightConverter.tonesToQuintals(input)
                        .stripTrailingZeros().toPlainString())
                    Units.G -> outputValue.setText(weightConverter.tonesToGrams(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.Q -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.quiToKg(input)
                        .stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(weightConverter.quiToTones(input)
                        .stripTrailingZeros().toPlainString())
                    Units.Q -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.G -> outputValue.setText(weightConverter.quiToGrams(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.G -> {
                when (toUnit) {
                    Units.KG -> outputValue.setText(weightConverter.gramsToKg(input)
                        .stripTrailingZeros().toPlainString())
                    Units.T -> outputValue.setText(weightConverter.gramsToTones(input)
                        .stripTrailingZeros().toPlainString())
                    Units.Q -> outputValue.setText(weightConverter.gramsToQuintals(input)
                        .stripTrailingZeros().toPlainString())
                    Units.G -> outputValue.setText(input.stripTrailingZeros().toPlainString())
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
                    Units.SEC -> outputValue.setText(timeConverter.hoursToSeconds(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.MIN -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(timeConverter.minToHours(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MIN -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.D -> outputValue.setText(timeConverter.minutesToDays(input)
                        .stripTrailingZeros().toPlainString())
                    Units.SEC -> outputValue.setText(timeConverter.minutesToSeconds(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.D -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(timeConverter.daysToHours(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MIN -> outputValue.setText(timeConverter.daysToMin(input)
                        .stripTrailingZeros().toPlainString())
                    Units.D -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.SEC -> outputValue.setText(timeConverter.daysToSeconds(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.SEC -> {
                when (toUnit) {
                    Units.H -> outputValue.setText(timeConverter.secondsToHours(input)
                        .stripTrailingZeros().toPlainString())
                    Units.MIN -> outputValue.setText(timeConverter.secondsToMin(input)
                        .stripTrailingZeros().toPlainString())
                    Units.D -> outputValue.setText(timeConverter.secondsToDays(input)
                        .stripTrailingZeros().toPlainString())
                    Units.SEC -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            else -> {}
        }
    }
}