package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    /**
     * This method decompose square of a number to the sum of squares
     */
    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 5) return null
        return decompose(sqr(number), number - 1)
    }

    private fun decompose(sqr: Int, reducedNumber: Int): Array<Int>? {
        for (i in reducedNumber downTo 1) {
            val rest = sqr - sqr(i)

            if (rest == 0) {
                return arrayOf(i)
            } else if (rest < 0) {
                return null
            }

            val possibleNext = sqrt(rest.toDouble()).toInt()
            val nextVal = if (possibleNext >= i) {
                decompose(rest, i - 1)
            } else {
                decompose(rest, possibleNext)
            }
            if (!nextVal.isNullOrEmpty())
                return nextVal + arrayOf(i)
        }
        return null
    }

    private fun sqr(n: Int) = n * n
}
