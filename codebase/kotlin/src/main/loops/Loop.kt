package main.loops

fun main() {
    val list1 = arrayListOf(1, 3, 5, 7, 9, 0, 2, 4, 6, 8)

    // forward traversal
    for (i in 0 until list1.size) {
        print("${list1[i]}, ")
    }
    println()

    // reverse traversal
    for (i in list1.size - 1 downTo 0) {
        print("${list1[i]}, ")
    }
    println()
}
