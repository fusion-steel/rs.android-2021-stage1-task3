package subtask1

import java.lang.IllegalArgumentException

class Combinator {

    /**
     * This method finds k from binomial coefficient formula
     */
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val n = array[0]
        val k = array[1]

        var res: Int? = null

        for (i in 1..k) {
            val currentCombination = combination(k, i)
            if (currentCombination == n) {
                res = i
                break
            }
        }
        return res
    }

    private fun Int.factorial(): Long {
        var i = 1
        var factorial: Long = 1
        while (i <= this) {
            factorial *= i.toLong()
            i++
        }
        return factorial
    }

    private fun combination(n: Int, k: Int): Int {
        if (n < k) throw IllegalArgumentException("n should be bigger than k")
        return (n.factorial() / (k.factorial() * (n - k).factorial())).toInt()
    }
}
