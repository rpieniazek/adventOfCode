package day3

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {


    val tab = Array(10000) { IntArray(10000) }
    try {
        Files.lines(Paths.get("src/day3/input.txt")).forEach { l ->
            val s = l.replace("#\\d+ @ ".toRegex(), "")
                    .replace(" ".toRegex(), "")
                    .replace("[#@,:x]".toRegex(), ",")
            //                System.out.println(s);
            val splitted = s.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val xCoord = Integer.parseInt(splitted[0])
            val yCoord = Integer.parseInt(splitted[1])
            val xCanvasSize = Integer.parseInt(splitted[2])
            val yCanvasSize = Integer.parseInt(splitted[3])
            for (i in 0 until xCanvasSize) {
                for (j in 0 until yCanvasSize) {
                    tab[xCoord + i][yCoord + j]++
                }
            }
        }
        var counter = 0

        for (i in tab.indices) {
            for (j in tab.indices) {
                if (tab[i][j] >= 2) {
                    counter++
                }
            }

        }
        println(counter)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}