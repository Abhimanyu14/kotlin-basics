package collections

fun main() {
    val set = setOf(1, 1, 2, 3)
    println(set) // [1, 2, 3]

    // any()
    val result = set.any { it % 2 == 0 }
    println(result)
}
