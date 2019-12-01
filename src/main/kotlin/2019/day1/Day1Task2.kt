package `2019`.day1

import java.io.File
import kotlin.streams.asStream

fun main() {
    File("src/main/kotlin/2019/day1/input.txt").useLines { lines ->
        println(lines.asStream()
            .map { line -> line.toInt() }
            .map { mass ->
                var sum = 0
                var calculated = Int.MAX_VALUE
                var massToCalculate = mass
                while (calculated > 5) {
                    calculated = calculateFuel(massToCalculate)
                    massToCalculate = calculated
                    sum += calculated
                }
                sum
            }
            .reduce { sum, element -> sum + element })
    }
}


fun calculateFuel(mass: Int): Int {
    return mass / 3 - 2
}
