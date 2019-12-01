package day2

import java.io.File

fun main(args: Array<String>) {

    val lines:MutableList<String> = ArrayList<String>();

    File("src/day2/input.txt").useLines { l ->
        l.toCollection(lines);
    }


    println(lines)
}