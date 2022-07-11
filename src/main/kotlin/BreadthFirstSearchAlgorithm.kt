import java.util.LinkedList
import java.util.Queue

object BreadthFirstSearchAlgorithm {
    @JvmStatic
    fun main(args: Array<String>) {
        val graph = createGraph()


        searchSeller(graph)
    }

    fun searchSeller(graph: HashMap<String, List<String>>): Boolean {
        val searchQueue: Queue<String> = LinkedList()
        searchQueue.addAll(graph["you"] ?: mutableListOf())

        while (searchQueue.isNotEmpty()) {
            for (queue in searchQueue) {
                print("$queue ")
            }
            println()

            val person = searchQueue.poll()

            if (isPersonSeller(person)) {
                println("$person is seller")
                return true
            } else {
                searchQueue.addAll(graph[person] ?: listOf())
            }
        }

        return false
    }

    fun isPersonSeller(person: String) : Boolean {
        return person.last() == 'm'
    }

    class Node(val isFinish: Boolean) {
        var leftNode: Node? = null
        var rightNode: Node? = null
    }

    fun createGraph(): HashMap<String, List<String>> {
        val graph = HashMap<String, List<String>>()
        graph["you"] = listOf("alice", "bob", "claire")
        graph["bob"] = listOf("anuj", "peggy")
        graph["alice"] = listOf("peggy")
        graph["claire"] = listOf("thom", "jonny")
        graph["anuj"] = listOf()
        graph["peggy"] = listOf()
        graph["thom"] = listOf()
        graph["jonny"] = listOf()

        return graph
    }

    fun createNodes(): Node {
        val sameNode = Node(false)
        val finishNode = Node(true)

        val nodes = Node(false)
        nodes.leftNode = Node(false)
        nodes.rightNode = Node(false)
        nodes.leftNode?.leftNode = finishNode
        nodes.leftNode?.rightNode = sameNode
        nodes.rightNode?.leftNode = sameNode
        nodes.rightNode?.rightNode = Node(false)
        nodes.rightNode?.rightNode?.leftNode = finishNode
        return nodes
    }
}