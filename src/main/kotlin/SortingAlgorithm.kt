object SortingAlgorithm {

//    lateinit var array: IntArray

    @JvmStatic
    fun main(args: Array<String>) {
        val list = mutableListOf(33, 10, 15, 7)
        val sortedList = quickSort(list, 0)

        sortedList.forEach { i ->
            print("$i ")
        }
    }

    fun quickSort(list: MutableList<Int>, pivotIndex: Int): List<Int> {
        val leftArray = mutableListOf<Int>()
        val rightArray = mutableListOf<Int>()

        if (list.size < 2) {
            return list
        }

        if (list.size == 2) {
            return if (list[0] > list[1]) {
                swap(list, 0, 1)
            } else {
                list
            }
        }

        val pivot = list[pivotIndex]
        list.removeAt(pivotIndex)

        list.forEach { number ->
            if (number <= pivot) {
                leftArray.add(number)
            } else {
                rightArray.add(number)
            }
        }

        return quickSort(leftArray, 0) + pivot + quickSort(rightArray, 0)
    }

    fun swap(list: MutableList<Int>, firstIndex: Int, lastIndex: Int): MutableList<Int> {
        val dump = list[firstIndex]
        list[firstIndex] = list[lastIndex]
        list[lastIndex] = dump
        return list
    }


//    fun sortArray(nums: IntArray): IntArray {
//        this.array = nums
//        quickSort(0, array.size - 1)
//        return array
//    }
//
//    fun quickSort(min: Int, max: Int) {
//        if (max - min == 2) {
//            if (array[max] < array[min]) {
//                swap(max, min)
//            }
//            return
//        }
//
//        if (max - min < 2) {
//            return
//        }
//
//        val pivotIndex = max
//        val pivot = array[pivotIndex]
//
//        var leftPointer = min
//        var rightPointer = max - 1
//
//        while (leftPointer < rightPointer) {
//            val currentLeft = array[leftPointer]
//            val currentRight = array[rightPointer]
//
//            if (currentLeft < pivot) {
//                leftPointer++
//            } else if (currentRight > pivot) {
//                rightPointer--
//            } else {
//                swap(leftPointer, rightPointer)
//            }
//        }
//
//        val mid = leftPointer // also same for right pointer
//        swap(mid, pivotIndex)
//
//        println(subArray(0, mid).contentToString())
//        println(subArray(mid + 1, pivotIndex).contentToString())
//        println()
//
//        quickSort(0, mid)
//        quickSort(mid + 1, pivotIndex)
//    }
//
//    fun swap(leftIndex: Int, rightIndex: Int) {
//        val dump = array[leftIndex]
//        array[leftIndex] = array[rightIndex]
//        array[rightIndex] = dump
//    }
//
//    fun subArray(leftIndex: Int, rightIndex: Int): IntArray {
//        return (leftIndex..rightIndex).map {
//            array[it]
//        }.toIntArray()
//    }

}