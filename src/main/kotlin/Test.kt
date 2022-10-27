object Test {
    private lateinit var array: IntArray

    @JvmStatic
    fun main(args: Array<String>) {
        val data = intArrayOf(4, 5, 2, 1, 3)

        println(mergeSort(data))
    }

    fun sort(data: IntArray): IntArray {
        for (i in data) {
            for (j in i + 1 until data.size) {
                val last = data[i]
                val current = data[j]

                if (last > current) {
                    val temp = data[i]
                    data[i] = data[j]
                    data[j] = temp
                }
            }
        }
        return data
    }

    fun mergeSort(nums: IntArray): IntArray {
        array = nums
        return mergeSort(0, array.size - 1)
    }

    fun mergeSort(leftIndex: Int, rightIndex: Int): IntArray {
        if (leftIndex == rightIndex) {
            return intArrayOf(array[leftIndex])
        }

        val k = (leftIndex + rightIndex) / 2
        val left = mergeSort(leftIndex, k)
        val right = mergeSort(rightIndex + 1, k)

        var leftPointer = 0
        var rightPointer = 0
        var arrayPointer = 0

        val sortedArray = IntArray(leftIndex + rightIndex)

        while (arrayPointer < sortedArray.size) {
            if (leftPointer >= left.size) {
                sortedArray[arrayPointer] = right[rightPointer]
                rightPointer++
                arrayPointer++
                continue
            }

            if (rightPointer >= right.size) {
                sortedArray[arrayPointer] = left[leftPointer]
                arrayPointer++
                continue
            }

            val currentLeft = left[leftPointer]
            val currentRight = right[rightPointer]

            if (currentLeft > currentRight) {
                array[arrayPointer] = currentLeft
                leftPointer++
            } else {
                array[arrayPointer] = currentRight
                rightPointer++
            }

            arrayPointer++
        }

        return sortedArray
    }
}