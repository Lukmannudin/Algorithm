object MergeSort {

    private lateinit var array: IntArray

    @JvmStatic
    fun main(args: Array<String>) {
        val sorted = sortArray(intArrayOf(4, 1, 2, 5))
        for (i in sorted) {
            print("$i ")
        }
    }

    fun sortArray(nums: IntArray): IntArray {
        array = nums
        return mergeSort(0, nums.size - 1)
    }

    fun mergeSort(leftIndex: Int, rightIndex: Int): IntArray {
        if (rightIndex == leftIndex) {
            return intArrayOf(array[leftIndex])
        }

        val k = (leftIndex + rightIndex) / 2
        val left = mergeSort(leftIndex, k)
        val right = mergeSort(k + 1, rightIndex)

        val sortedArray = IntArray(left.size + right.size)
        var arrayPointer = 0
        var leftPointer = 0
        var rightPointer = 0

        while (leftPointer < left.size || rightPointer < right.size) {
            if (leftPointer >= left.size || rightPointer >= right.size) {
                if (leftPointer >= left.size) {
                    sortedArray[arrayPointer] = right[rightPointer]
                    rightPointer++
                } else {
                    sortedArray[arrayPointer] = left[leftPointer]
                    leftPointer++
                }
                arrayPointer++
                continue
            }

            if (left[leftPointer] <= right[rightPointer]) {
                sortedArray[arrayPointer] = left[leftPointer]
                leftPointer++
            } else {
                sortedArray[arrayPointer] = right[rightPointer]
                rightPointer++
            }

            arrayPointer++
        }

        return sortedArray
    }
}