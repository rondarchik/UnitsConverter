package rondarchik.calculator.converter.converters

import java.math.BigDecimal

class TimeConverter {
    private val hoursToMinutes = BigDecimal(60)
    private val hoursToDays = BigDecimal(24)
    private val hoursToSeconds = BigDecimal(3600)

    private val minutesToDays = BigDecimal(1440)
    private val minutesToSeconds = BigDecimal(60)

    private val daysToSeconds = BigDecimal(86400)

    fun hoursToMinutes(value: BigDecimal) : BigDecimal {
        return value*hoursToMinutes
    }

    fun minToHours(value: BigDecimal) : BigDecimal {
        return value/hoursToMinutes
    }

    fun hoursToDays(value: BigDecimal) : BigDecimal {
        return value/hoursToDays
    }

    fun daysToHours(value: BigDecimal) : BigDecimal {
        return value*hoursToDays
    }

    fun hoursToSeconds(value: BigDecimal) : BigDecimal {
        return value*hoursToSeconds
    }

    fun secondsToHours(value: BigDecimal) : BigDecimal {
        return value/hoursToSeconds
    }

    fun minutesToDays(value: BigDecimal) : BigDecimal {
        return value/minutesToDays
    }

    fun daysToMin(value: BigDecimal) : BigDecimal {
        return value*minutesToDays
    }

    fun minutesToSeconds(value: BigDecimal) : BigDecimal {
        return value*minutesToSeconds
    }

    fun secondsToMin(value: BigDecimal) : BigDecimal {
        return value/minutesToSeconds
    }

    fun daysToSeconds(value: BigDecimal) : BigDecimal {
        return value*daysToSeconds
    }

    fun secondsToDays(value: BigDecimal) : BigDecimal {
        return value/daysToSeconds
    }
}
