import linkedlist.DoubleNode

/*
* Insert, search, delete
*
*           ()
*       ()      ()
*     () ()    () ()
*
* */
class BinarySearch2 {

    val root: DoubleNode<Int>? = null

    /*
    * 1. Check if the root is null, then insert
    * 2. Check if the target is root is greater than the target,
    * 3. then insert target to the left node and if not vice versa
    *
    * */

    fun insert(root: DoubleNode<Int>?, target: Int): DoubleNode<Int>? {
        if(root == null){
            return DoubleNode(data = target)
        } else if(root.data > target){
            root.prev = insert(root.prev, target)
        } else if(root.data < target){
            root.next = insert(root.next, target)
        }
        return root
    }

    /*
    *
    *
    * */
    fun search(root: DoubleNode<Int>?, target: Int): Boolean {

        return if (root == null){
             false
        } else if(root.data == target){
             true
        } else if (root.data < target){
            search(root.next, target)
        } else search(root.prev, target)
    }





}