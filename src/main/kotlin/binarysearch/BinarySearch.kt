package binarysearch

import linkedlist.DoubleNode

class BinarySearchTree {
    var root: DoubleNode<Int>? = null

    fun insert(root: DoubleNode<Int>?, element: Int): DoubleNode<Int> {
        if (root == null) {
            return DoubleNode(data = element)
        } else if (root.data > element) {
            root.prev = insert(root.prev, element)
        } else if (root.data < element) {
            root.next = insert(root.next, element)
        }
        return root
    }

    fun search(root: DoubleNode<Int>?, element: Int): Boolean {
        return if (root == null) {
            false
        } else if (root.data == element) {
            true
        } else if (root.data < element) {
            search(root.next, element)
        } else search(root.prev, element)
    }

    fun delete(root: DoubleNode<Int>?, element: Int): DoubleNode<Int>? {
        if (root == null) {
            return null
        } else if (root.data < element) {
            root.next = delete(root.next, element)
        } else if (root.data > element) {
            root.prev = delete(root.prev, element)
        } else {

            if (root.prev == null && root.next == null) {
                return null
            }
            if (root.prev == null) {
                return delete(root.next, element)
            }
            if (root.next == null) {
                return delete(root.prev, element)
            }

            val rightMin = rightMin(root.next)
            root.data = rightMin
            root.next = delete(root, rightMin)

        }

        return root
    }

    fun rightMin(root: DoubleNode<Int>?): Int {
        var temp = root

        while (temp?.prev != null) {
            temp = temp.prev
        }

        return temp?.data!!
    }

    fun inOrder(root: DoubleNode<Int>?) {
        if(root == null){
            return
        }
        inOrder(root.prev)
        println(root.data)
        inOrder(root.next)
    }
}

fun main(args: Array<String>) {
    val bst = BinarySearchTree()
    bst.root = bst.insert(bst.root, 100)
    bst.root = bst.insert(bst.root, 50)
    bst.root = bst.insert(bst.root, 150)
    bst.root = bst.insert(bst.root, 125)
//    bst.inorder(bst.root)
}