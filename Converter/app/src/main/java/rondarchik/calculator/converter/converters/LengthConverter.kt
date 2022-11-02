package rondarchik.calculator.converter.converters

import java.math.BigDecimal

class LengthConverter {

    private val metersToKilometers = BigDecimal(1000)
    private val metersToFeet = BigDecimal(3.2808399)
    private val metersToMiles = BigDecimal(0.000621371192)

    private val kilometersToFeet = BigDecimal(3280.8399)
    private val kilometersToMiles = BigDecimal(0.621371192)

    private val feetToMiles = BigDecimal(5280)

    fun metersToKilometers(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(metersToKilometers)
        else
            value.multiply(metersToKilometers)
    }

    fun metersToFeet(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(metersToFeet)
        else
            value.divide(metersToFeet)
    }

    fun metersToMiles(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(metersToMiles)
        else
            value.divide(metersToMiles)
    }

    fun kilometersToFeet(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(kilometersToFeet)
        else
            value.divide(kilometersToFeet)
    }

    fun kilometersToMiles(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(kilometersToMiles)
        else
            value.divide(kilometersToMiles)
    }

    fun feetToMiles(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(feetToMiles)
        else
            value.multiply(feetToMiles)
    }
}