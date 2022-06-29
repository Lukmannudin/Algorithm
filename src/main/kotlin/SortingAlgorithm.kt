object SortingAlgorithm {

    lateinit var array: IntArray

    fun sortArray(nums: IntArray): IntArray {
        array = nums
        quickSort(0, nums.lastIndex)
        return array
    }

    private fun quickSort(left: Int, right: Int) {
        var leftIndex = left
        var rightIndex = right

        val size = (right - left) + 1

        // base case
        if (size < 2) {
            return
        }

        // base case
        if (size == 2) {
            if (array[leftIndex] > array[rightIndex]) {
                swap(leftIndex, rightIndex)
            }
        }

        val pivotIndex = right
        val pivot = array[pivotIndex]

        while (leftIndex < rightIndex) {
            if (array[leftIndex] <= pivot) {
                leftIndex++
            } else if (array[rightIndex] >= pivot) {
                rightIndex--
            } else {
                swap(leftIndex, rightIndex)
            }
        }

        swap(leftIndex, pivotIndex)

        val newPivot = leftIndex

        quickSort(left, newPivot - 1)
        quickSort(newPivot + 1, right)
    }

    fun swap(firstIndex: Int, secondIndex: Int) {
        val dump = array[firstIndex]
        array[firstIndex] = array[secondIndex]
        array[secondIndex] = dump
    }

}