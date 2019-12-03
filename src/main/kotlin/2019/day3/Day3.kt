package `2019`.day3

import java.io.File
import java.lang.Math.abs
import java.util.*


data class Point(var x: Int, var y: Int) {
    override fun toString(): String {
        return "[$x,$y]"
    }
}

fun main() {
    val wires = File("src/main/kotlin/2019/day3/input.txt")
        .readLines()
    val wire1 = wires[0].split(",").toTypedArray()
    val wire2 = wires[1].split(",").toTypedArray();

    val calculatePath1 = calculatePath(wire1)
    val calculatePath2 = calculatePath(wire2)

    val result = calculatePath1.intersect(calculatePath2)

    val part1 = result
        .map { abs(it.x) + abs(it.y) }
        .min()

    val part2 = result
        .map { calculatePath1.indexOf(it) + calculatePath2.indexOf(it) }
        .map { it + 2 }
        .min()

    println(part1)
    println(part2)
}

fun calculatePath(wire: Array<String>): List<Point> {
    val startingPoint = Point(0, 0)
    val visitedForWire = ArrayList<Point>()
    for (command in wire) {
        //parse command
        val direction = command[0];
        val distance = command.substring(1).toInt()
        when (direction) {
            'U' -> {
                for (pointer in 0 until distance) {
                    startingPoint.y++
                    visitedForWire.add(Point(startingPoint.x, startingPoint.y))
                }

            }
            'D' -> {
                for (pointer in 0 until distance) {
                    startingPoint.y--
                    visitedForWire.add(Point(startingPoint.x, startingPoint.y))
                }

            }
            'R' -> {
                for (pointer in 0 until distance) {
                    startingPoint.x++
                    visitedForWire.add(Point(startingPoint.x, startingPoint.y))
                }

            }
            'L' -> {
                for (pointer in 0 until distance) {
                    startingPoint.x--
                    visitedForWire.add(Point(startingPoint.x, startingPoint.y))
                }
            }
        }
    }
    return visitedForWire

}
