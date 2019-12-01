package day2

import java.io.File

fun main(args: Array<String>) {

    var twoOccurences: Int = 0;
    var threOccurences = 0;
    File("src/day2/input.txt").useLines { lines ->
        lines.forEach { line ->

            val groupBy = line.toList().groupingBy({ c: Char -> c }).eachCount()

            val byTwo: Int = groupBy.entries.filter { entry -> entry.value == 2 }.size
            val byThree = groupBy.entries.filter { entry -> entry.value == 3 }.size

            if (byTwo > 0) {
                twoOccurences++
            }
            if (byThree > 0) {
                threOccurences++
            }

        }
    }
    var checkSum = twoOccurences * threOccurences;
    print(checkSum)
}