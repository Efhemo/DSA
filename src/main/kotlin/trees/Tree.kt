package trees

typealias Visitor<T> = (TreeNode<T>) -> Unit

class  TreeNode<T>(val value: T) {
    val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(element: TreeNode<T>) = children.add(element)

    //Depth first traversal
    //Starts at the root node and explores the trees as far
    // as possible along each branch before reaching a leaf and the backtracking
    fun forEachDepthFirst(visit: (TreeNode<T>) -> Unit){
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    //Todo: Level order traversal


    //search first
    fun search(element: T): TreeNode<T>? {
        var node: TreeNode<T>? = null

        forEachDepthFirst {
            if (it.value == element){
                node = it
                return@forEachDepthFirst
            }
        }
        return node
    }
}

fun main(){

    val tree = makeBeverageTree()
    //tree.forEachDepthFirst { println(it.value) }
    tree.search("ginger ale")?.let {
        println("Found node: ${it.value}")
    }
}

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)
    return tree
}



