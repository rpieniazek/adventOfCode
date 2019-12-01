import java.util.stream.Stream

object MapTest {
    @JvmStatic
    fun main(args: Array<String>) {
        Stream.of(1, 4, 6)
            .map { el ->
                var sum = 0
                var calculated: Int
                do {
                    calculated = calc(el!!)
                    sum += calculated
                } while (calculated > 0)
                sum
            }
    }

    private fun calc(a: Int): Int {
        return a / 3 - 2
    }
}
