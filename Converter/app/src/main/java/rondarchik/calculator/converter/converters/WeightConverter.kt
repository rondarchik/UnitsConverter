package rondarchik.calculator.converter.converters

class WeightConverter {
    private val kilogramsToTones = (1.0 / 1000.0)
    private val kilogramsToPounds = 2.20462262185
    private val kilogramsToOunces = kilogramsToPounds * 16.0

    private val tonesToPounds = kilogramsToPounds * 1000
    private val tonesToOunces = kilogramsToOunces * 1000

    private val poundsToOunces = 16.0

    fun kilogramsToTones(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * kilogramsToTones
        else
            value / kilogramsToTones
    }

    fun kilogramsToPounds(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * kilogramsToPounds
        else
            value / kilogramsToPounds
    }

    fun kilogramsToOunces(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * kilogramsToOunces
        else
            value / kilogramsToOunces
    }

    fun tonesToPounds(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * tonesToPounds
        else
            value / tonesToPounds
    }

    fun tonesToOunces(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * tonesToOunces
        else
            value / tonesToOunces
    }

    fun poundsToOunces(value: Double, isReverseConversion: Boolean = false) : Double {
        return if (!isReverseConversion)
            value * poundsToOunces
        else
            value / poundsToOunces
    }

}