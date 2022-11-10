package rondarchik.calculator.converter.converters

import java.math.BigDecimal
import java.math.RoundingMode
import java.math.BigDecimal.ROUND_HALF_UP as round

class VolumeConverter {
    private val mlToCm3 = BigDecimal(1)
    private val mlToL = BigDecimal(1000)
    private val mlToM3 = BigDecimal(1000000)

    private val cm3ToL = BigDecimal(1000)
    private val cm3ToM3 = BigDecimal(1000000)

    private val lToM3 = BigDecimal(1000)

    fun mlToCm3 (value: BigDecimal) : BigDecimal {
        return value.multiply(mlToCm3)
    }

    fun cm3ToMl (value: BigDecimal) : BigDecimal {
        return value.divide(mlToCm3)
    }

    fun mlToL (value: BigDecimal) : BigDecimal {
        return value.divide(mlToL)
    }

    fun lToMl (value: BigDecimal) : BigDecimal {
        return value.multiply(mlToL)
    }

    fun mlToM3 (value: BigDecimal) : BigDecimal {
        return value.divide(mlToM3)
    }

    fun m3ToMl (value: BigDecimal) : BigDecimal {
        return value.multiply(mlToM3)
    }

    fun cm3ToL (value: BigDecimal) : BigDecimal {
        return value.divide(cm3ToL)
    }

    fun lToCm3 (value: BigDecimal) : BigDecimal {
        return value.multiply(cm3ToL)
    }

    fun cm3ToM3 (value: BigDecimal) : BigDecimal {
        return value.divide(cm3ToM3)
    }

    fun m3ToCm3 (value: BigDecimal) : BigDecimal {
        return value.multiply(cm3ToM3)
    }

    fun lToM3 (value: BigDecimal) : BigDecimal {
        return value.divide(lToM3)
    }

    fun m3ToL (value: BigDecimal) : BigDecimal {
        return value.multiply(lToM3)
    }
}
