package classes

fun main() {
    // Pairs
    val pair = "first item" to "second item"
    println(pair) // (first item, second item)
    println(pair.first) // first item
    println(pair.second) // second item
    println()

    // Chaining
    val pair2 = "first" to "second" to "third" to "fourth"
    println(pair2) // (((first, second), third), fourth)
    println(pair2.first) // ((first, second), third)
    println(pair2.first.first) // (first, second)
    println(pair2.first.first.first) // first
    println(pair2.first.first.second) // second
    println(pair2.first.second) // third
    println(pair2.second) // fourth
    println()

    // Separating using parenthesis
    val pair3 = ("first" to "second") to ("third" to "fourth")
    println(pair3) // ((first, second), (third, fourth))
    println(pair3.first) // (first, second)
    println(pair3.first.first) // first
    println(pair3.first.second) // second
    println(pair3.second) // (third, fourth)
    println(pair3.second.first) // third
    println(pair3.second.second) // fourth
    println()

    // Destructuring or decomposing
    val pair4 = "first" to "second"
    val (item1, item2) = pair4
    println(item1) // first
    println(item2) // second
    println()

    // toString()
    val pair5 = "first" to "second"
    println(pair5.toString()) // (first, second)
    println()

    // toList()
    println(pair5.toList()) // [first, second]
    println()

    // Using Pair keyword
    val pair6 = Pair("first", "second")
    println(pair6) // (first, second)
    println()
}
