package subtask3

class TelephoneFinder {

    /**
     * This method finds number neighbors of the given telephone numbers.
     * Neighbors are considered by phone keyboard if they appear directly
     * next to or above/below each other
     */
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val res = mutableListOf<String>()
        val possibleCombinations = mapOf(
            "1" to "24",
            "2" to "135",
            "3" to "26",
            "4" to "157",
            "5" to "2468",
            "6" to "359",
            "7" to "48",
            "8" to "5790",
            "9" to "68",
            "0" to "8"
        )

        for ((index, item) in number.withIndex()) {
            val values = possibleCombinations[item.toString()]
            if (values != null) {
                for (j in values) {
                    res.add(number.take(index) + j + number.drop(index + 1))
                }
            } else {
                return null
            }
        }
        return res.toTypedArray()
    }
}
