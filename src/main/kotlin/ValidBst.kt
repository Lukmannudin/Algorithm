//object ValidBst {
//
//    @JvmStatic
//    fun main(args: Array<String>) {
////        val node = TreeNode(5)
////        node.left = TreeNode(1)
////        node.right = TreeNode(4)
////        node.right?.left = TreeNode(3)
////        node.right?.right = TreeNode(6)
//
////        val node = TreeNode(-2147483648)
////        node.left = null
////        node.right = TreeNode(2147483647)
//
////        val node = TreeNode(2147483647)
////        node.left = TreeNode(2147483647)
//
//
//        val node = TreeNode(-2147483648)
//        node.left = TreeNode(-2147483648)
//
////        val node = TreeNode(2)
////        node.left = TreeNode(2)
////        node.right = TreeNode(2)
//
//        println(isValidBST(node))
//    }
//
//    fun isValidBST(root: TreeNode?): Boolean {
//        if (root == null) {
//            return true
//        }
//
//
//
//
//        return isValidBST(root.left, min, root.`val`) && isValidBST(root.right, root.`val`, max)
//    }
//
//    fun leftBst(root: TreeNode?, max: Int): Boolean {
//        if (root == null) {
//            return true
//        }
//
//        if (root.left != null && root.left?.`val`!! >= root.`val`) {
//            return false
//        }
//
//        if (root.right != null && root.right?.`val`!! <= root.`val`) {
//            return false
//        }
//
//        if (root.`val` >= max) {
//            return false
//        }
//
//        return leftBst(root, root.`val`)
//    }
//
//    fun rightBst(root: TreeNode?, min: Int): Boolean {
//        if (root == null) {
//            return true
//        }
//
//        if (root.left != null && root.left?.`val`!! >= root.`val`) {
//            return false
//        }
//
//        if (root.right != null && root.right?.`val`!! <= root.`val`) {
//            return false
//        }
//
//        if (root.`val` <= min) {
//            return false
//        }
//
//        return
//    }
//
//    fun isValidBST(root: TreeNode?, min: Int, max: Int): Boolean {
//        if (root == null) {
//            return true
//        }
//
//        if (root.left != null && root.left?.`val`!! >= root.`val`) {
//            return false
//        }
//
//        if (root.right != null && root.right?.`val`!! <= root.`val`) {
//            return false
//        }
//
//        if (root.`val` >= max || root.`val` <= min) {
//            return false
//        }
//
//        return isValidBST(root.left, min, root.`val`) && isValidBST(root.right, root.`val`, max)
//    }
//
//    class TreeNode(var `val`: Int) {
//        var left: TreeNode? = null
//        var right: TreeNode? = null
//    }
//}