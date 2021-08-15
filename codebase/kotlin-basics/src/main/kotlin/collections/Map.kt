package collections

fun main() {
    val map = mapOf(1 to "first", 3 to "third", 5 to "five", 7 to "seven", 9 to "nine")

    // Indexing access preferred over method access
    println(map.get(1)) // first
    println(map[1]) // first

    // getOrDefault()
    println(map.getOrDefault(2, "default")) // default

    // getOrElse()
    val ele = (map.getOrElse(2) {
        println("else")
    })
    println(ele)
    // else
    // kotlin.Unit

    // getOrPut(()
    val mutableMap = mutableMapOf(1 to "first")
    println(mutableMap)
    val result = mutableMap.getOrPut(2) { "second" }
    println(result)
    println(mutableMap)
}
