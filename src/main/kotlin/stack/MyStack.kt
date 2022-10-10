package stack

import linkedlist.MyLinkedListImp

interface MyStack<T: Any> {

    fun push(element: T)

    fun pop() : T?

    fun peek(): T?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0

}

class MyStackImp<T: Any>: MyStack<T> {

    private val list = arrayListOf<T>()

    override fun push(element: T) {
        list.add(element)
    }

    override fun pop(): T? {
        return list.removeLastOrNull()
    }

    override fun peek(): T? {
        return list.lastOrNull()
    }

    override val count: Int
        get() = list.size

}

class MyStackLinkedList: MyStack<Int> {

    val linked = MyLinkedListImp<Int>()

    override fun push(element: Int) {
        linked.add(element)
    }

    override fun pop(): Int? {
        val data = linked.head?.data
        if(data != null) {
            linked.delete(data)
            return data
        }
        return null
    }

    override fun peek(): Int? {
        return linked.head?.data
    }

    override val count: Int
        get() = linked.size

}

fun String.isValidParenthesis(): Boolean {

    val stack = MyStackImp<Char>()

    for (char in this){
        when(char){
            '(' -> stack.push(char)
            ')' -> {
                if(stack.isEmpty){
                    return false
                } else {
                    stack.pop()
                }
            }
        }
    }

    return stack.isEmpty

}

fun main(){
    println("((())))".isValidParenthesis())

    val stack = MyStackLinkedList()
    stack.push(30)
    stack.push(20)
    stack.push(10)

    stack.pop()

    println(stack.peek())
}