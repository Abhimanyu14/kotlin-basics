package main.generics

class MyArray<T>(val size: Int) {

}

fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

// Array<? extends Object>
fun copyWithOut(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

// Array<? super String>
fun fill(dest: Array<in String>, value: String) {

}

fun main() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    // not allowed
    // copy(ints, any)
    // required: Array<Any>
    // found: Array<Int>

    copyWithOut(ints, any)
    fill(any, "test")
}
