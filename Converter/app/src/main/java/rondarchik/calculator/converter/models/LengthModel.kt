package rondarchik.calculator.converter.models

class LengthModel {

    val metersToKilometers: Double
    val metersToFeet: Double
    val metersToMiles: Double

    val kilometersToFeet: Double
    val kilometersToMiles: Double

    val feetToMiles: Double

    init {
        metersToKilometers = (1.0 / 1000.0)
        metersToFeet = 3.28084
        metersToMiles = (1.0 / 1609.34)

        kilometersToFeet = metersToFeet * 1000
        kilometersToMiles = metersToMiles * 1000

        feetToMiles = (1.0 / 5280.0)
    }
}