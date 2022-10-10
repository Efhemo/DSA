package queue

interface MyQueue<T: Any> {

    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun enqueue(element: T): Boolean

    fun dequeue(): T?

    fun peak(): T?
}

class MyQueueImp<T: Any>: MyQueue<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun dequeue(): T? {
        return if(isEmpty) null else storage.removeAt(0)
    }

    override fun peak(): T? {
        return storage.firstOrNull()
    }

    override fun enqueue(element: T): Boolean {
        return storage.add(element)
    }

}