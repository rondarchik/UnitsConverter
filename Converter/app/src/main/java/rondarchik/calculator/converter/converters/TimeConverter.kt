package rondarchik.calculator.converter.converters

import java.math.BigDecimal
import java.math.BigDecimal.ROUND_DOWN
import java.math.RoundingMode

class TimeConverter {
    private val hoursToMinutes = BigDecimal(60)
    private val hoursToDays = BigDecimal(24)
    private val hoursToWeeks = BigDecimal(168)

    private val minutesToDays = BigDecimal(1440)
    private val minutesToWeeks = BigDecimal(10080)

    private val daysToWeeks = BigDecimal(7)

    fun hoursToMinutes(value: BigDecimal) : BigDecimal {
        return value*hoursToMinutes
    }

    fun minToHours(value: BigDecimal) : BigDecimal {
        return value.divide(hoursToMinutes, 50, ROUND_DOWN)
    }

    fun hoursToDays(value: BigDecimal) : BigDecimal {
        return value.divide(hoursToDays, 50, ROUND_DOWN)
    }

    fun daysToHours(value: BigDecimal) : BigDecimal {
        return value*hoursToDays
    }

    fun hoursToWeeks(value: BigDecimal) : BigDecimal {
        return value.divide(hoursToWeeks, 50, ROUND_DOWN)
    }

    fun weeksToHours(value: BigDecimal) : BigDecimal {
        return value*hoursToWeeks
    }

    fun minutesToDays(value: BigDecimal) : BigDecimal {
        return value.divide(minutesToDays, 50, ROUND_DOWN)
    }

    fun daysToMin(value: BigDecimal) : BigDecimal {
        return value*minutesToDays
    }

    fun minutesToWeeks(value: BigDecimal) : BigDecimal {
        return value.divide(minutesToWeeks, 50, ROUND_DOWN)
    }

    fun weeksToMin(value: BigDecimal) : BigDecimal {
        return value*minutesToWeeks
    }

    fun daysToWeeks(value: BigDecimal) : BigDecimal {
        return value.divide(daysToWeeks, 50, ROUND_DOWN)
    }

    fun weeksToDays(value: BigDecimal) : BigDecimal {
        return value*daysToWeeks
    }
}
