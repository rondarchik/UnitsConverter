package rondarchik.calculator.converter.converters

class LengthConverter {

    private val metersToKilometers = (1.0 / 1000.0)
    private val metersToFeet = 3.28084
    private val metersToMiles = (1.0 / 1609.34)

    private val kilometersToFeet = metersToFeet * 1000
    private val kilometersToMiles = metersToMiles * 1000

    private val feetToMiles = (1.0 / 5280.0)

    fun metersToKilometers(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * metersToKilometers
        else
            value / metersToKilometers
    }

    fun metersToFeet(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * metersToFeet
        else
            value / metersToFeet
    }

    fun metersToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * metersToMiles
        else
            value / metersToMiles
    }

    fun kilometersToFeet(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * kilometersToFeet
        else
            value / kilometersToFeet
    }

    fun kilometersToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * kilometersToMiles
        else
            value / kilometersToMiles
    }

    fun feetToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * feetToMiles
        else
            value / feetToMiles
    }
}