import java.util.*


object HuffmanCoding {
    @JvmStatic
    fun main(args: Array<String>) {
        val frequencies = mapOf(
                'a' to 5,
                'b' to 9,
                'c' to 12,
                'd' to 13,
                'e' to 16,
                'f' to 45
        )

        huffman(frequencies)
    }

    fun huffman(frequencies: Map<Char, Int>) {
        val queue: PriorityQueue<HuffmanNode> = PriorityQueue(frequencies.size, HuffmanComparator())

        frequencies.forEach { key, value ->
            val node = HuffmanNode(key, value)
            queue.add(node)
        }

        var root: HuffmanNode? = null

        while (queue.size > 1) {
            val firstNode = queue.poll()
            val secondNode = queue.poll()

            val node = HuffmanNode('-', firstNode.data + secondNode.data)
            node.left = firstNode
            node.right = secondNode

            root = node
            queue.add(node)
        }

        printCode(root, "")
    }

    fun printCode(root: HuffmanNode?, s: String) {

        if ((root?.left == null) && (root?.right
                        == null) && Character.isLetter(root?.key ?: ' ')) {

            // c is the character in the node
            println("" + root?.key + ":" + s)
            return
        }

        printCode(root?.left, s + "0")
        printCode(root?.right, s + "1")
    }

    class HuffmanNode(
            val key: Char,
            val data: Int
    ) {
        var left: HuffmanNode? = null
        var right: HuffmanNode? = null
    }

    class HuffmanComparator : Comparator<HuffmanNode> {
        override fun compare(o1: HuffmanNode?, o2: HuffmanNode?): Int {
            val object1 = o1?.data ?: 0
            val object2 = o2?.data ?: 0
            return object1 - object2
        }
    }
}

