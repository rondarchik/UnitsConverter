package rondarchik.calculator.converter.converters

import java.math.BigDecimal
import java.math.BigDecimal.ROUND_DOWN
import java.math.BigDecimal.ROUND_HALF_UP
import java.math.RoundingMode

class TimeConverter {
    private val hoursToMinutes = BigDecimal(60).multiply(BigDecimal(10)).divide(BigDecimal(10))
    private val hoursToDays = BigDecimal(24).multiply(BigDecimal(10)).divide(BigDecimal(10))
    private val hoursToWeeks = BigDecimal(168).multiply(BigDecimal(10)).divide(BigDecimal(10))

    private val minutesToDays = BigDecimal(1440).multiply(BigDecimal(10)).divide(BigDecimal(10))
    private val minutesToWeeks = BigDecimal(10080).multiply(BigDecimal(10)).divide(BigDecimal(10))

    private val daysToWeeks = BigDecimal(7).multiply(BigDecimal(10)).divide(BigDecimal(10))

    fun hoursToMinutes(value: BigDecimal) : BigDecimal {
        return value.multiply(hoursToMinutes).setScale(20, ROUND_HALF_UP)
    }

    fun minToHours(value: BigDecimal) : BigDecimal {
        return value.divide(hoursToMinutes, 50, ROUND_DOWN)
    }

    fun hoursToDays(value: BigDecimal) : BigDecimal {
        return value.divide(hoursToDays, 50, ROUND_DOWN)
    }

    fun daysToHours(value: BigDecimal) : BigDecimal {
        return value.multiply(hoursToDays).setScale(20, ROUND_HALF_UP)
    }

    fun hoursToWeeks(value: BigDecimal) : BigDecimal {
        return value.divide(hoursToWeeks, 50, ROUND_DOWN)
    }

    fun weeksToHours(value: BigDecimal) : BigDecimal {
        return value.multiply(hoursToWeeks).setScale(20, ROUND_HALF_UP)
    }

    fun minutesToDays(value: BigDecimal) : BigDecimal {
        return value.divide(minutesToDays, 50, ROUND_DOWN)
    }

    fun daysToMin(value: BigDecimal) : BigDecimal {
        return value.multiply(minutesToDays).setScale(20, ROUND_HALF_UP)
    }

    fun minutesToWeeks(value: BigDecimal) : BigDecimal {
        return value.divide(minutesToWeeks, 50, ROUND_DOWN)
    }

    fun weeksToMin(value: BigDecimal) : BigDecimal {
        return value.multiply(minutesToWeeks).setScale(20, ROUND_HALF_UP)
    }

    fun daysToWeeks(value: BigDecimal) : BigDecimal {
        return value.divide(daysToWeeks, 50, ROUND_DOWN)
    }

    fun weeksToDays(value: BigDecimal) : BigDecimal {
        return value.multiply(daysToWeeks).setScale(20, ROUND_HALF_UP)
    }
}
