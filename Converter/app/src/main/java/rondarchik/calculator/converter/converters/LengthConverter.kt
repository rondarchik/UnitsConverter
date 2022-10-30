package rondarchik.calculator.converter.converters

import rondarchik.calculator.converter.models.LengthModel

class LengthConverter {

    private val lengthModel = LengthModel()

    fun metersToKilometers(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.metersToKilometers
        else
            value / lengthModel.metersToKilometers
    }

    fun metersToFeet(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.metersToFeet
        else
            value / lengthModel.metersToFeet
    }

    fun metersToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.metersToMiles
        else
            value / lengthModel.metersToMiles
    }

    fun kilometersToFeet(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.kilometersToFeet
        else
            value / lengthModel.kilometersToFeet
    }

    fun kilometersToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.kilometersToMiles
        else
            value / lengthModel.kilometersToMiles
    }

    fun feetToMiles(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * lengthModel.feetToMiles
        else
            value / lengthModel.feetToMiles
    }
}