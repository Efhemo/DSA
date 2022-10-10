package graph

//A representation of graph in Matrix form
class AdjMatrix (private val isIndirection : Boolean =  false) {

    private val v = 5
    private val arr = Array(v) { IntArray(v) }

    fun addEdge( srcIndex: Int, destIndex: Int){
        arr[srcIndex][destIndex] = 1
        if(isIndirection){
            arr[destIndex][srcIndex] = 1
        }
    }

    fun hasEdge(srcIndex: Int, destIndex: Int): Boolean{
        if(arr[srcIndex][destIndex] == 1){
            return true
        }
        return false
    }

    fun removeEdge(srcIndex: Int, destIndex: Int){
        arr[srcIndex][destIndex] = 0
        if(isIndirection){
            arr[destIndex][srcIndex] = 0
        }
    }

    override fun toString(): String {
        var s = ""

//        for (i in 0 until v){
//            for (j in 0 until v){
//                s = "$s${arr[i][j]} "
//            }
//            s += "\n"
//        }

        //or
        arr.forEach { it ->
            it.forEach {
                s = "$s$it "
            }
            s += "\n"
        }
        return s
    }
}

fun main() {
    val obj = AdjMatrix(true)
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
    println("Adjacency Matrix Representation of the Graph")
    println(obj)
    println("has edge 1 to 4 ${obj.hasEdge(1, 4)}")
    println("has edge 1 to 5 ${obj.hasEdge(0, 4)}")
}
