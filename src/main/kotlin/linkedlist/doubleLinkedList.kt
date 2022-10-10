package linkedlist

data class DoubleNode<T: Any> (var prev: DoubleNode<T>? = null, var data: T, var next: DoubleNode<T>? = null)

interface MyDoubleLinkedList<T: Any> {

    fun add(e: T): Boolean

    fun addLast(e: T): Boolean

    fun search(e: T): Boolean

    fun delete(e: T)

}

class MyDoubleLinkedListImp<T: Any> : MyDoubleLinkedList<T> {

    var head: DoubleNode<T>? = null

    override fun add(e: T): Boolean {
        val newNode = DoubleNode(data = e)

        if (head == null){
            newNode.prev = null
            newNode.next = null
            head = newNode
        } else {
            newNode.prev = null
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }

        return true
    }

    override fun addLast(e: T): Boolean {
        val newNode = DoubleNode(data = e)

        if(head == null){
            newNode.prev = null
            newNode.next = null
            head = newNode
        } else {
            var lastNode = head
            while (lastNode?.next != null){
                lastNode = lastNode.next
            }
            lastNode?.next = newNode
            newNode.prev = lastNode
            newNode.next = null
        }

        return true
    }

    override fun search(e: T): Boolean {

        if(head == null){
            return false
        }

        var temp = head
        while (temp != null){
            if (temp.data == e){
                return true
            }
            temp = temp.next
        }
        return false
    }

    override fun delete(e: T) {

        if(head == null){
            return
        }

        if(head?.data == e){
            val nextNode = head?.next
            nextNode?.prev = null
            head = nextNode
        } else {
            var temp = head
            while (temp != null){
                if(temp.data == e){
                    val prevNode = temp.prev

                    val nextNote = temp.next

                    prevNode?.next = temp.next
                    nextNote?.prev = prevNode

                    break
                }
                temp = temp.next
            }
        }
    }

    override fun toString(): String {
        var s = ""
        var node = head
        while (node != null){
            s += "${node.data}"
            node = node.next
        }
        return s
    }

}

fun main(){
    val doubleLinkedList = MyDoubleLinkedListImp<Int>()

    doubleLinkedList.addLast(10)
    doubleLinkedList.addLast(20)
    doubleLinkedList.addLast(30)
    doubleLinkedList.addLast(40)

    doubleLinkedList.delete(40)

    println(doubleLinkedList.toString())

    val isPresent = doubleLinkedList.search(40)
    println("isPresent: $isPresent")
}