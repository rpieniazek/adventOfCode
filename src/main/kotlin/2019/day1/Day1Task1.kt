package `2019`.day1

import java.io.File
import kotlin.streams.asStream


fun main(args: Array<String>) {

    File("src/main/kotlin/2019/day1/input.txt").useLines { lines ->
        println(lines.asStream()
            .map { line -> line.toInt() }
            .map({ mass -> mass / 3 - 2 })
            .reduce { sum, element -> sum + element })
    }
}
