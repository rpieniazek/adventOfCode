package `2019`.day2

import java.io.File

fun main() {

    for (noun in 0..99) {
        for (verb in 0..99) {
            var opcodes = File("src/main/kotlin/2019/day2/input.txt")
                .readText()
                .split(",")
                .map { line -> (line.trim().toInt()) }
                .toTypedArray()

            opcodes[1] = noun
            opcodes[2] = verb
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
            if (opcodes[0] == 19690720) {
                println("noun: $noun")
                println("verb: $verb")
                println("result: " + noun * 100 + verb)
            }
        }
    }

}
