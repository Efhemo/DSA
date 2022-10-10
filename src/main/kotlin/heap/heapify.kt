package heap


/*
* A binary heap is a complete binary tree which satisfies the heap ordering property
*
* Full tree and complete
* A full tree is a tree in which every node other than the leaves has two children
*
* A complete tree is a full tree in which the last level may contain lesser nodes but
* it should be as left as possible
*
*               Two types of heap: Min heap and Max Heap
* Min heap: Parent node is lesser than the children node value
* Max heap: Parent node value will be greater than the children value
*
* In min heap, the low priority will be present at the root and
*  in max heap, the max priority will be present at the root
*
*        ()
    ()      ()
  () ()    () ()
*
* */
class Heapify {

    fun buildHeapify(array: Array<Int>){

        for (i in (array.size / 2) downTo  0){
            heapify(array, i)
        }
    }

    fun heapify(array: Array<Int>, index: Int){
        val left = 2 * index + 1
        val right = left + 1

        var max = index

        //left <= array.size checking if
        if(left <= array.size && array[left] > array[max]){
            max = left
        }

        if (right <= array.size && array[right] > array[max]){
            max = right
        }

        if(index != max){
            array[left] = array[max].also { array[max] = array[left] }
            heapify(array, max)
        }

    }

}