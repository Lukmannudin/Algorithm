
object BinarySquare {
    @JvmStatic
    fun main(args: Array<String>) {
        printBinarySquare(5)
    }

    fun printBinarySquare(square: Int) {
        for (i in 0 until square) {
            var binaryBoolean = intToBoolean(i % 2)
            for (j in 0 until square) {
                val char = booleanToChar(binaryBoolean)
                print("$char")
                binaryBoolean = !binaryBoolean
            }
        }
    }

    fun booleanToChar(boolean: Boolean): Char {
        return if (boolean) {
            '1'
        } else {
            '0'
        }
    }

    fun intToBoolean(value: Int) : Boolean {
        return value == 1
    }
}