package main.functions

// Extension function
fun Int.isPositive(): Boolean = this > 0

// Extension property
data class Student(val name: String)

val Student.hasLongName: Boolean
    get() = name.length > 10

fun main() {
    println("${0.isPositive()}")
    println("${1.isPositive()}")
    println("${(-1).isPositive()}")
    println()

    val stu1 = Student("Sam")
    val stu2 = Student("Michael Jackson")
    println(stu1.hasLongName)
    println(stu2.hasLongName)
    println()
}
