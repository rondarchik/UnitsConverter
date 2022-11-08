package rondarchik.calculator.converter.converters

import java.math.BigDecimal

class WeightConverter {
    private val kilogramsToTones = BigDecimal(1000)
    private val kilogramsToQuintals = BigDecimal(100)
    private val kilogramsToGrams = BigDecimal(1000)

    private val tonesToQuintals = BigDecimal(10)
    private val tonesToGrams = BigDecimal(1000000)

    private val quintalsToGrams = BigDecimal(100000)

    fun kilogramsToTones(value: BigDecimal) : BigDecimal {
        return value.divide(kilogramsToTones)
    }

    fun tonesToKg(value: BigDecimal) : BigDecimal {
        return value.multiply(kilogramsToTones)
    }

    fun kilogramsToQuintals(value: BigDecimal) : BigDecimal {
        return value.divide(kilogramsToQuintals)
    }

    fun quiToKg(value: BigDecimal) : BigDecimal {
        return value.multiply(kilogramsToQuintals)
    }

    fun kilogramsToGrams(value: BigDecimal) : BigDecimal {
        return value.multiply(kilogramsToGrams)
    }

    fun gramsToKg(value: BigDecimal) : BigDecimal {
        return value.divide(kilogramsToGrams)
    }

    fun tonesToQuintals(value: BigDecimal) : BigDecimal {
        return value.multiply(tonesToQuintals)
    }

    fun quiToTones(value: BigDecimal) : BigDecimal {
        return value.divide(tonesToQuintals)
    }

    fun tonesToGrams(value: BigDecimal) : BigDecimal {
        return value.multiply(tonesToGrams)
    }

    fun gramsToTones(value: BigDecimal) : BigDecimal {
        return value.divide(tonesToGrams)
    }

    fun quiToGrams(value: BigDecimal) : BigDecimal {
        return value.multiply(quintalsToGrams)
    }

    fun gramsToQuintals(value: BigDecimal) : BigDecimal {
        return value.divide(quintalsToGrams)
    }

}