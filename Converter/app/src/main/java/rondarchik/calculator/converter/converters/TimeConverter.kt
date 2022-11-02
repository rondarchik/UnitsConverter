package rondarchik.calculator.converter.converters

import java.math.BigDecimal

class TimeConverter {
    private val hoursToMinutes = BigDecimal(60)
    private val hoursToDays = BigDecimal(24)
    private val hoursToYears = BigDecimal(8760)

    private val minutesToDays = BigDecimal(1440)
    private val minutesToYears = BigDecimal(525600)

    private val daysToYears = BigDecimal(365)

    fun hoursToMinutes(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.multiply(hoursToMinutes)
        else
            value.divide(hoursToMinutes)
    }

    fun hoursToDays(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(hoursToDays)
        else
            value.multiply(hoursToDays)
    }

    fun hoursToYears(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(hoursToYears)
        else
            value.multiply(hoursToYears)
    }

    fun minutesToDays(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(minutesToDays)
        else
            value.multiply(minutesToDays)
    }

    fun minutesToYears(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(minutesToYears)
        else
            value.multiply(minutesToYears)
    }

    fun daysToYears(value: BigDecimal, isReverseConversion: Boolean = false) : BigDecimal {
        return if (!isReverseConversion)
            value.divide(daysToYears)
        else
            value.multiply(daysToYears)
    }
}
