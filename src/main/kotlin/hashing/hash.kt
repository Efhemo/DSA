package hashing


/**
 * hashing is an efficient way of storing and accessing element.
 *
 *
 * It is exactly same as index page of a book. In the index page, every topic is
 * associated with a page number. likewise, every value will be associated with a key.
 * So, using the key, we can directly point out the value.
 *
 * As binary search improve searching of element, we can even improve more on searching uzing hashing
 *
 * */


//linear probing
class Hash {

    private val arr = Array<Int>(5){ -1 }

    fun insert(element: Int): Int {

        val key = element % arr.size // this, so that the key will be in the range of arr.size
        var index = key

        //to avoid collision
        while (arr[index] != -1){
            index = (index + 1) % arr.size
            if(index == key){ // this indicates that we have iterate through the array
                return 0
            }
        }

        arr[index] = element
        return 1
    }

    fun delete(value: Int): Int {
        val key = value % arr.size
        var index = key

        while (arr[index] != value){ //while arr[index] is not equal to the value to be deleted,

            //increase the index, formula for checking next available index value:
            index = (index + 1) % arr.size // this (% arr.size) because we don't want index > than the size of arr

            if(index == key){
                return 0
            }
        }
        arr[index] = -1 //if arr[index] is the value delete by doing this
        return 1
    }

    fun search(value: Int): Boolean {
        val key = value % arr.size
        var index = key

        while (arr[index] != value){
            index = (index + 1) % arr.size

            if (key == index){
                return false
            }
        }

        return true
    }

}