package array


fun main(args: Array<String>){
    val arr = arrayOf( 1, 2, 3, 10)


    //println(s)
}

fun main (){
    //1
    val myArray = intArrayOf(25, 14, 56, 15, 36, 56, 77, 18, 29, 49)
    val position = 2
    val value = 5
    println(insertAt(myArray, value, position).contentToString())

    println()
    //2
    println(search(myArray, 15))
    println()
    //3
    println(removeAt(myArray, 9).contentToString())

    println("running sum")
    println(runningSum(arrayOf(3, 1, 2, 10, 1)).contentToString())

    println("Richest")
    val account = arrayOf(arrayOf(7, 1, 3), arrayOf(2, 8, 7), arrayOf(1, 9, 5))
    println(richestCustomer(account))

}

//Your task is to insert the new element in the array at the given position ‘pos’.
fun insertAt(array: IntArray, element: Int, position: Int): IntArray {
    val newArray = IntArray(array.size + 1)
    //start inserting existing element
    for (i in newArray.indices){

        if(i == position){
            newArray[position] = element
        } else if (i > position){
            newArray[i] = array[i - 1]
        } else {
            newArray[i] = array[i]
        }
    }
    return newArray
}

fun search(array: IntArray, element: Int): Boolean {
    for (i in array){
        if(element == i){
            return true
        }
    }
    return false
}

fun removeAt(array: IntArray, position: Int): IntArray {
    val newArray = IntArray(array.size - 1)

    var x = 0
    for (i in array.indices){
        if( i == position) {
            continue
        }
        newArray[x] = array[i]
        x++
    }
    return newArray
}


//runningSum
//Example
//input: [3, 1, 2, 10, 1]
//output: [3, 4, 6, 16, 17]
fun runningSum(nums: Array<Int>): Array<Int> {
    for (i in 1 until nums.size){
        nums[i] = nums[i - 1] + nums[i]
    }
    return nums

    //Time complexity: 0(n)
    //Space complexity: 0(1)
}

//richest customer
//Example
//Input: [[7, 1, 3], [2, 8, 7], [1, 9, 5]]
//Output: 17
fun richestCustomer(arr: Array<Array<Int>>): Int {

    var x = 0
    for (i in arr){
        val sum = i.sum()
        if(x < sum){
            x = sum
        }
    }

    return x

    //Time complexity: 0(n x m)
    //Space complexity: 0(1)
}