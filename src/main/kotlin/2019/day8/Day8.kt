package `2019`.day8

import java.io.File

data class Layer(var pixels: List<Int>) {
    fun getAmountOfDigits(digit: Int): Int {
        return pixels
            .filter { it == digit }
            .count()
    }

    override fun toString(): String {
        return pixels.toString()
    }
}

const val W: Int = 25
const val H: Int = 6

class Picture(layers: List<Layer>) {

    private val image: IntArray

    init {
        image = IntArray(W * H) { 2 }
        layers.forEach {
            for ((index, pixel) in it.pixels.withIndex()) {
                if (image[index] == 2) {
                    image[index] = pixel
                }
            }
        }
        println()
    }

    fun printPicture() {
        this.image.map { it.toString() }
            .chunked(W)
            .forEach {
                it.forEach { c -> if (c == "0") print(" ") else print("X") }
                println()
            }
    }
}

fun main() {
    val pixels = File("src/main/kotlin/2019/day8/input.txt")
        .readText()

    val chunked = pixels.subSequence(0, pixels.length - 1).chunked(W * H)
    val layers = chunked
        .map { toIntArray(it) }
        .map { Layer(it) }

    val minLayer = layers.minBy { it.getAmountOfDigits(0) }

    if (minLayer != null) {
        val numberOfOnes = minLayer.getAmountOfDigits(1)
        val numberOfTwos = minLayer.getAmountOfDigits(2)
        println(numberOfOnes * numberOfTwos)
    }

    val picture = Picture(layers)
    picture.printPicture()
}

fun toIntArray(it: String): List<Int> {
    return it.map { Character.getNumericValue(it) }
}
