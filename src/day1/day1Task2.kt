package day1

import java.io.File


fun main(args: Array<String>) {
    val frequences: MutableSet<Int> = HashSet<Int>();
    val changes:MutableList<Int> = ArrayList<Int>();

    File("src/day1/input.txt").useLines { lines ->
        lines.forEach { line ->
            changes.add(line.toInt())
        }
    }
    var sum = 0;
    var found = false;
    do {
        changes.forEach {change ->
            sum += change
            if(!frequences.add(sum)){
                found = true
                println(sum)
                return
            }
        }
    }
    while(!found)


}

