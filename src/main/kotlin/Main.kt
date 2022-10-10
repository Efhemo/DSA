import java.util.*

fun main(args: Array<String>) {
//    println("Hello World!")
//
//    // Try adding program arguments via Run/Debug configuration.
//    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//
//    val by = 6 downTo 0 step 2
//
//    val list = arrayListOf<String>()
//
//    list.add("3")
//
//    "list".let {
//        println("priny $it")
//    }
//
//    foo()

    //for (i in by) println(i)

    //for (l in by.withIndex()) println("index ${l.index} and value ${l.value}")


    var arr = intArrayOf(4, 7, 5, 2)
    val sjs = arr.sum()
//    val key = 3
//    val index = 2
//
//    arr = insertAt(arr, key, index)
//
    println(sjs)

    val ks = LinkedList<Int>()
    ks.remove(8)

    println("-----------")
    val js = "ssds"
    val ase = js.split("_")
    val byte = byteArrayOf(0xE0.toByte(), 0xF8.toByte(), 0xC8.toByte())


}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
        print(value)
    })
    print(" done with anonymous function")
}