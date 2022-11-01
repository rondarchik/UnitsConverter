package rondarchik.calculator.converter.converters

class TimeConverter {
    private val hoursToMinutes = 60.0
    private val hoursToDays = (1 / 24).toDouble()
    private val hoursToYears = hoursToDays / 365

    private val minutesToDays = hoursToDays / 60.0
    private val minutesToYears = hoursToYears / 60.0

    private val daysToYears = (1 / 365).toDouble()

    fun hoursToMinutes(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * hoursToMinutes
        else
            value / hoursToMinutes
    }

    fun hoursToDays(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * hoursToDays
        else
            value / hoursToDays
    }

    fun hoursToYears(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * hoursToYears
        else
            value / hoursToYears
    }

    fun minutesToDays(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * minutesToDays
        else
            value / minutesToDays
    }

    fun minutesToYears(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * minutesToYears
        else
            value / minutesToYears
    }

    fun daysToYears(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * daysToYears
        else
            value / daysToYears
    }
}
