object EuclidAlgorithm {

    @JvmStatic
    fun main(args: Array<String>) {
        println(euclid(18, euclid(24, 36)))
    }

    fun euclid(num1: Int, num2: Int): Int {
        if (num2 == 0) {
            return num1
        }

        val a: Int
        val b: Int

        // swap if b > a
        if (num1 > num2) {
            a = num1
            b = num2
        } else {
            a = num2
            b = num1
        }

        val div = a / b
        val r = a - (b * div)

        return euclid(b, r)
    }


}