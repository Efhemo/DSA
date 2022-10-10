fun binarySearch(arr: IntArray, target: Int): Boolean {
    var start = 0
    var end = arr.size - 1

    var middle: Int
    while (start <= end) {
        middle = (start + end) / 2

        if (arr[middle] == target){
            return true
        }
        if(arr[middle] < target) {
            start = middle + 1
        } else {
            end = middle - 1
        }
    }
    return false
}

fun main(){
    val myArray = intArrayOf(14, 15, 18, 25, 29, 36, 49, 56, 77)
    println("is present: ${binarySearch(myArray, 49)}")
}
