package rondarchik.calculator.converter.converters

import java.math.BigDecimal

class LengthConverter {

    private val metersToKilometers = BigDecimal(1000)
    private val metersToCentimeters = BigDecimal(100)
    private val metersToMillimeters = BigDecimal(1000)

    private val kilometersToCentimeters = BigDecimal(100000)
    private val kilometersToMillimeters = BigDecimal(1000000)

    private val centimetersToMillimeters = BigDecimal(10)

    fun metersToKilometers(value: BigDecimal) : BigDecimal {
        return  value.divide(metersToKilometers)
    }

    fun kilometersToMeters(value: BigDecimal) : BigDecimal {
        return  value.multiply(metersToKilometers)
    }

    fun metersToCentimeters(value: BigDecimal) : BigDecimal {
        return value.multiply(metersToCentimeters)
    }

    fun centimetersToMeters(value: BigDecimal) : BigDecimal {
        return value.divide(metersToCentimeters)
    }

    fun metersToMillimeters(value: BigDecimal) : BigDecimal {
        return value.multiply(metersToMillimeters)
    }

    fun mmToMeters(value: BigDecimal) : BigDecimal {
        return value.divide(metersToMillimeters)
    }

    fun kilometersToCm(value: BigDecimal) : BigDecimal {
        return value.multiply(kilometersToCentimeters)
    }

    fun cmToKilometers(value: BigDecimal) : BigDecimal {
        return value.divide(kilometersToCentimeters)
    }

    fun kilometersToMm(value: BigDecimal) : BigDecimal {
        return value.multiply(kilometersToMillimeters)
    }

    fun mmToKilometers(value: BigDecimal) : BigDecimal {
        return value.divide(kilometersToMillimeters)
    }

    fun cmToMM(value: BigDecimal) : BigDecimal {
        return value.multiply(centimetersToMillimeters)
    }

    fun mmTOCm(value: BigDecimal) : BigDecimal {
        return value.divide(centimetersToMillimeters)
    }
}