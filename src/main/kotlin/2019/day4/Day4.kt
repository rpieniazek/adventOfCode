package `2019`.day4

fun main() {
    val rangeStart = 125730;
    val rangeStop = 579381;

    var counter = 0;
    for (potentiallyPassword in rangeStart..rangeStop) {
        if (isPasswordTask1(potentiallyPassword.toString())) {
            counter++
        }
    }
    println("Part1:" + counter)

    counter = 0;
    for (potentiallyPassword in rangeStart..rangeStop) {
        if (isPasswordTask2(potentiallyPassword.toString())) {
            counter++
        }
    }
    println("Part2:" + counter)
}

fun isPasswordTask1(number: String): Boolean {
    return neverDecrease(number) && adjacentDigits(number)
}

fun isPasswordTask2(number: String): Boolean {
    return neverDecrease(number) && adjacentOnly2Digits(number)
}

fun adjacentOnly2Digits(number: String): Boolean {
    val digits = HashMap<Char, Int>()

    number.toCharArray().forEach {
        var amount = digits.get(it)
        if (amount != null) {
            digits.put(it, ++amount)
        } else
            digits.put(it, 1)
    }

    return digits.values.contains(2)
}

fun adjacentDigits(number: String): Boolean {
    return number.toCharArray().toCollection(hashSetOf()).size < 6
}

fun neverDecrease(number: String): Boolean {
    val charArray = number.toCharArray();
    for (i in 0 until 5) {
        if (charArray[i] > charArray[i + 1]) {
            return false
        }
    }
    return true
}
