package sort


//Take one and compare with the rest
fun selectionSort(array: Array<Int>){
    //start from zero, but end in < size - 1, (E.g if 5 ~ < size - 1 => < 4)
    // because by the last index, the highest number would have been at the last index
    for (i in 0  until array.size - 1){

        for (j in (i + 1) until array.size){
            if(array[i] > array[j]){
                //swap
                array[i] = array[j].also { array[j] = array[i] }
            }
        }
    }
}

//Comparing first and second index, if first > second, swap it, then compare second and third and so on.
//By the first iteration, the highest would have been at the last index, so minus one in the next iteration
fun bubbleSort(array: Array<Int>){

    for (i in 0 until array.size - 1){

        var flag = 0
        for (j in 0 until (array.size - 1 - i)){
            if(array[j] > array[j + 1]){
                flag = 1
                //swap
                array[j] = array[j + 1].also { array[j + 1] =  array[j] }
            }
        }
        if(flag == 0){
            break
        }

    }
}

fun main(){
    val arr = arrayOf(180, 165, 150, 170, 145)

    bubbleSort(arr)
    println(arr.contentToString())

}