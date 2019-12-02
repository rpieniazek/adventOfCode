package `2019`.day2

import java.io.File

fun main() {


    var opcodes = File("src/main/kotlin/2019/day2/input.txt")
        .readText()
        .split(",")
        .map { line -> (line.trim().toInt()) }
        .toTypedArray()

    opcodes[1] = 12
    opcodes[2] = 2
    var processing = true
    var instructionPointer = 0
    while (processing) {
        val input1Pointer = opcodes[instructionPointer + 1]
        val input2Pointer = opcodes[instructionPointer + 2]
        val outputPointer = opcodes[instructionPointer + 3]

        if (opcodes[instructionPointer] == 1) {
            val result = opcodes[input1Pointer] + opcodes[input2Pointer]
            opcodes[outputPointer] = result
        }
        if (opcodes[instructionPointer] == 2) {
            val result = opcodes[input1Pointer] * opcodes[input2Pointer]
            opcodes[outputPointer] = result
        }
        if (opcodes[instructionPointer] == 99) {
            processing = false
        }
        instructionPointer += 4
    }

    opcodes.forEach { line -> println(line) }
}
