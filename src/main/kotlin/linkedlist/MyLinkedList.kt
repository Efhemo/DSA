package linkedlist

data class MyNode<T>(val data: T, var next: MyNode<T>? = null)

interface MyLinkedList<T: Any> {

    fun add(e: T): Boolean

    fun addLast(e: T): Boolean

    fun delete(e: T)

    fun middle(): MyNode<T>?
}

class MyLinkedListImp<T: Any> : MyLinkedList<T> {

    var head: MyNode<T>? = null
    var size = 0

    //Since we are just adding a (one) new Node, time complexity will be 0(1) - constant time
    override fun add(e: T): Boolean {
        val newNode = MyNode(e)
        newNode.next = head

        head = newNode
        size++
        return true
    }

    override fun addLast(e: T): Boolean {
        val newNode = MyNode(e, null)

        if (head == null){
            head = newNode
        } else {
            var lastNode = head
            //we have gotten to the end if the list when .next is null
            while (lastNode?.next != null){
                lastNode = lastNode.next
            }
            lastNode?.next = newNode
        }

        size++
        return true
    }

    override fun delete(e: T) {
        if(head == null){
            return
        }
        if (head?.data == e){
            head = head?.next
        } else {
            var node = head
            while (node?.next != null){
                if(node.next?.data == e){
                    node.next = node.next?.next
                    size--
                    break
                } else node = node.next
            }
        }

    }

    //if there two middle nodes, return the second middle node
    override fun middle(): MyNode<T>? {
        var temp = head

        if(temp?.next == null){
            return head
        }

        var count = 0
        while (temp != null){
            temp = temp.next
            count++
        }


        val middle: Int = (count / 2)

        var temp2 = head

        for (i in 1 until middle){
            temp2 = temp2?.next
        }

        return temp2?.next

        //or
//        var middleNode = head
//        var endNode = head
//
//        while (endNode?.next != null){
//            middleNode = middleNode?.next
//            endNode = endNode.next?.next
//        }
//
//        return middleNode

    }

    fun search(element: T): Boolean {
        var temp: MyNode<T>? = head

        while (temp != null){
            if(temp.data == element){
                return true
            }
            temp = temp.next
        }
        return false
    }


    override fun toString(): String {
        var s = ""
        var node = head
        while (node != null) {
            s += "${node.data}"
            node = node.next
        }
        return s
    }
}

fun main(){
    val list = MyLinkedListImp<Int>()
    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.addLast(4)
    list.addLast(5)
    list.addLast(6)


    //list.delete(6)

    println(list.toString())

    println("middle: ${list.middle()}")


    val list2 = MyLinkedListImp<Int>()
    list2.addLast(9)
    list2.addLast(9)
    list2.addLast(9)
    list2.addLast(9)
    list2.addLast(9)
    list2.addLast(9)
    list2.addLast(9)

    val list3 = MyLinkedListImp<Int>()
    list3.addLast(9)
    list3.addLast(9)
    list3.addLast(9)
    list3.addLast(9)


    println(addTwoNumberss(list2.head, list3.head))

}


fun addTwoNumberss(l1: MyNode<Int>?, l2: MyNode<Int>?): MyNode<Int>? {
    var l1: MyNode<Int>? = l1
    var l2: MyNode<Int>? = l2
    val dummyHead = MyNode<Int>(0, null)
    var curr: MyNode<Int> = dummyHead
    var carry = 0
    while (l1 != null || l2 != null || carry != 0) {
        val x = l1?.data ?: 0
        val y = l2?.data ?: 0
        val sum = carry + x + y
        carry = sum / 10
        curr.next = MyNode<Int>(sum % 10, null)
        curr = curr.next!!
        if (l1 != null) l1 = l1.next
        if (l2 != null) l2 = l2.next
    }
    return dummyHead.next
}