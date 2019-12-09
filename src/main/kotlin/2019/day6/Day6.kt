package `2019`.day6

import java.io.File

fun main() {
    val planets = File("src/main/kotlin/2019/day6/input.txt")
        .readLines()

    val orbits = HashMap<String, String>()
    for (planet in planets) {
        val splitMapEntry = planet.split(")")
        val fromPlanet = splitMapEntry[0]
        val toPlanet = splitMapEntry[1]
        orbits[toPlanet] = fromPlanet;
    }

    var totalDistance = 0
    for (connection in orbits) {
        var singlePath = 1
        var destination = connection.value
        while (!destination.equals("COM")) {
            destination = orbits.getOrDefault(destination, "")
            singlePath++
        }
        totalDistance += singlePath
    }

    println(totalDistance)
    val youToCom = pathToCOM(orbits, "YOU")
    val sanToCom = pathToCOM(orbits, "SAN")

    val orbitsFromMeToSanta: ArrayList<Int> = ArrayList()
    for ((youIndex, youPlanet) in youToCom.withIndex()) {
        for ((santaIndex, santaPlanet) in sanToCom.withIndex()) {
            if (youPlanet.equals(santaPlanet)) {
                orbitsFromMeToSanta.add(youIndex + santaIndex)
            }
        }
    }

    val part2: Int? = orbitsFromMeToSanta.min()
    println("Part2:" + part2?.minus(2))
}

fun pathToCOM(orbits: Map<String, String>, start: String): ArrayList<String> {
    val path = ArrayList<String>()
    var destination = start
    while (!destination.equals("COM")) {
        path.add(destination)
        destination = orbits.getOrDefault(destination, "")
    }
    return path
}
