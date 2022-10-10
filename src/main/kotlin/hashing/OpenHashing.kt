package hashing

import linkedlist.MyDoubleLinkedListImp
import linkedlist.MyNode

//quadratic probing
// called Opening hashing or separate chaining
class OpenHashing {

    private val arr = Array<MyNode<Int>?>(5){ null }

    fun insert(element: Int){
        val key = element % arr.size
        val node = MyNode<Int>(data = element, next = null)

        val keyHead = arr[key]

        if(keyHead == null){
            arr[key] = node
        } else {
            var temp = keyHead
            while (temp?.next != null){
                temp = temp.next
            }
            temp?.next = node
        }
    }


    fun search(element: Int): Boolean {

        val key = element % arr.size //get the index of the element
        var temp = arr[key]

        while (temp != null){
            if(temp.data == element){
                return true
            }
            temp = temp.next
        }

        return false
    }

    fun delete(element: Int){

        val key = element % arr.size
        var temp = arr[key]

        if(temp?.data == element){
            arr[key] = temp.next
            return
        }
        while (temp?.next != null){
            if(temp.next?.data == element){
                temp.next = temp.next?.next
                return
            }
            temp = temp.next
        }
    }


    override fun toString(): String {
        var s = ""

        for (i in arr.indices){
            var temp = arr[i]

            while (temp != null){
                s += temp.data
                temp = temp.next
            }
            s += "\n"
        }
        return s
    }
}

fun main(){
    val doubleLinkedList = OpenHashing()

    doubleLinkedList.insert(10)
    doubleLinkedList.insert(20)
    doubleLinkedList.insert(30)
    doubleLinkedList.insert(40)

    doubleLinkedList.delete(20)

    println(doubleLinkedList.toString())

    val isPresent = doubleLinkedList.search(40)
    println("isPresent: $isPresent")
}