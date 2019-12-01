package day1

import java.io.File


fun main(args:Array<String>){
    var sum = 0;
    File("src/day1/input.txt").useLines { lines -> lines.forEach { line -> sum += line.toInt() } }
    print(sum)
}

