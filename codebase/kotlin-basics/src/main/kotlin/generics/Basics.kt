package generics

// Invariant
class Box<T>(input: T) {
    val value = input
    fun produce(): T {
        return value
    }

    fun consume(t: T) {
    }
}

// Producer - Extends - out
// Covariant
class OutBox<out T>(input: T) {
    val value = input

    fun produce(): T {
        return value
    }

    // not allowed
    // fun consume(t: T) {
    // }
}

// Consumer - Super - in
// Contravariant
class InBox<in T>(input: T) {
    // not allowed
    // val t = input

    // not allowed
    // fun produce(): T {
    //     return t
    // }

    fun consume(t: T) {
    }
}

fun main() {
    val intBox = Box(5)
    println(intBox.value)

    val stringBox = Box("Dragon Ball Z")
    println(stringBox.value)

    val boxedIntBox = Box(intBox)
    println(boxedIntBox.value.value)
}
