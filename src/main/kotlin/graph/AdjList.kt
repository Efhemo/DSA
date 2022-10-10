package graph

import linkedlist.MyNode

class AdjList {

    val V = 5

    var arr: Array<MyNode<Int>?> = arrayOfNulls(V)


    fun addEdge(src: Int, dest: Int) {

        val node = MyNode(data = dest, next = null)
        node.next = arr[src]
        arr[src] = node

    }

    fun removeEdge(src: Int, dest: Int) {
        if (arr[src] == null) {
            return
        }

        if(arr[src]?.data == dest){
            arr[src] = arr[src]?.next
            return
        }

        var current = arr[src]
        var temp = arr[src]

         while (current?.next != null){
             if(current.data == dest){
                 temp = current.next
                 current.next = temp?.next
                 break
             }
             temp = temp?.next
         }
    }

    fun hasEdge(src: Int, dest: Int): Boolean {

        var temp = arr[src]

        while (temp != null) { //loop to the end (i.e till temp == null)
            if(temp.data == dest){
                return true
            }
            temp = temp.next
        }
        return false

    }

    override fun toString(): String {

        var s = ""
        for (i in 0 until V){
            var indexArr = arr[i]

            while (indexArr != null){
                s += "${indexArr.data} "
                indexArr = indexArr.next
            }
            s += "\n"
        }
        return s
    }
}

fun main(args: Array<String>) {
    val obj = AdjList()
    println("Adding Edge From 0 to 1")
    obj.addEdge(0, 1)
    println("Adding Edge From 0 to 2")
    obj.addEdge(0, 2)
    println("Adding Edge From 0 to 3")
    obj.addEdge(0, 3)
    println("Adding Edge From 1 to 3")
    obj.addEdge(1, 3)
    println("Adding Edge From 1 to 4")
    obj.addEdge(1, 4)
    println("Adding Edge From 2 to 3")
    obj.addEdge(2, 3)
    println("Adding Edge From 3 to 4")
    obj.addEdge(3, 4)
    println("Adjacency List Representation of the Graph")

    obj.removeEdge(0, 3)

    println(obj)

    //obj.hasEdge(1, 3)
    println("has Edge: ${obj.hasEdge(2, 3)}")

}