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
            Units.ML, Units.CM3, Units.L, Units.M3 -> volumeConvert(inputValue, outputValue, fromUnit, toUnit)
        }
    }

    private fun lengthConvert (inputValue: EditText, outputValue: EditText,
                               fromUnit: Units, toUnit: Units) {

        if (inputValue.length() == 0)
            return

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

        if (inputValue.length() == 0)
            return

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

    private fun volumeConvert (inputValue: EditText, outputValue: EditText,
                               fromUnit: Units, toUnit: Units) {

        if (inputValue.length() == 0)
            return

        val input = inputValue.text.toString().toBigDecimal()

        val volumeConverter = VolumeConverter()

        when (fromUnit) {
            Units.ML -> {
                when (toUnit) {
                    Units.ML -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.CM3 -> outputValue.setText(volumeConverter.mlToCm3(input)
                        .stripTrailingZeros().toPlainString())
                    Units.L -> outputValue.setText(volumeConverter.mlToL(input)
                        .stripTrailingZeros().toPlainString())
                    Units.M3 -> outputValue.setText(volumeConverter.mlToM3(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                }
                return
            }
            Units.CM3 -> {
                when (toUnit) {
                    Units.ML -> outputValue.setText(volumeConverter.cm3ToMl(input)
                        .stripTrailingZeros().toPlainString())
                    Units.CM3 -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.L -> outputValue.setText(volumeConverter.cm3ToL(input)
                        .stripTrailingZeros().toPlainString())
                    Units.M3 -> outputValue.setText(volumeConverter.cm3ToM3(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.L -> {
                when (toUnit) {
                    Units.ML -> outputValue.setText(volumeConverter.lToMl(input)
                        .stripTrailingZeros().toPlainString())
                    Units.CM3 -> outputValue.setText(volumeConverter.lToCm3(input)
                        .stripTrailingZeros().toPlainString())
                    Units.L -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    Units.M3 -> outputValue.setText(volumeConverter.lToM3(input)
                        .stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            Units.M3 -> {
                when (toUnit) {
                    Units.ML -> outputValue.setText(volumeConverter.m3ToMl(input)
                        .stripTrailingZeros().toPlainString())
                    Units.CM3 -> outputValue.setText(volumeConverter.m3ToCm3(input)
                        .stripTrailingZeros().toPlainString())
                    Units.L -> outputValue.setText(volumeConverter.m3ToL(input)
                        .stripTrailingZeros().toPlainString())
                    Units.M3 -> outputValue.setText(input.stripTrailingZeros().toPlainString())
                    else -> outputValue.setText(input.stripTrailingZeros().toPlainString())

                }
                return
            }
            else -> {}
        }
    }
}