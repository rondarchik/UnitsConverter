package rondarchik.calculator.converter.converters

import java.math.BigDecimal

class WeightConverter {
    private val kilogramsToTones = BigDecimal(1000)
    private val kilogramsToPounds = BigDecimal(2.20462262)
    private val kilogramsToOunces = BigDecimal(35.2739619)

    private val tonesToPounds = kilogramsToPounds.multiply(kilogramsToTones)
    private val tonesToOunces = kilogramsToOunces.multiply(kilogramsToTones)

    private val poundsToOunces = BigDecimal(16)

    fun kilogramsToTones(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(kilogramsToTones)
        else
            value.multiply(kilogramsToTones)
    }

    fun kilogramsToPounds(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(kilogramsToPounds)
        else
            value.divide(kilogramsToPounds)
    }

    fun kilogramsToOunces(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(kilogramsToOunces)
        else
            value / kilogramsToOunces
    }

    fun tonesToPounds(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(tonesToPounds)
        else
            value.divide(tonesToPounds)
    }

    fun tonesToOunces(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(tonesToOunces)
        else
            value.divide(tonesToOunces)
    }

    fun poundsToOunces(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(poundsToOunces)
        else
            value.divide(poundsToOunces)
    }

}