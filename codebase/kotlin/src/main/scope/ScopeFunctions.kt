package main.scope

data class Person(var name: String = "", var age: Int = -1)

/**
 * scope functions - let, run, with, apply and also
 */
fun main() {
    // non-null, expression as variable
    letSample()
    // object configuration and computing the result
    runSample()
    // grouping function calls with a object
    withSample()
    // object configuration
    applySample()
    // additional effects
    alsoSample()
}

private fun letSample() {
    val person = Person(name = "Sam", age = 24)

    println("let")
    val letResult = person.let {
        println("$it")
        it.name = "Max"
        println("$it")
        "last"
    }
    println(letResult)
    println()
}

private fun runSample() {
    val person = Person(name = "Sam", age = 24)

    println("run")
    val runResult = person.run {
        println("$this")
        name = "Max"
        println("$this")
        "last"
    }
    println(runResult)
    println()
}

private fun withSample() {
    val person = Person(name = "Sam", age = 24)

    println("with")
    val withResult = with(person) {
        println("$this")
        name = "Max"
        println("$this")
        "last"
    }
    println(withResult)
    println()
}

private fun applySample() {
    val person = Person(name = "Sam", age = 24)

    println("apply")
    val applyResult = person.apply {
        println("$this")
        name = "Max"
        println("$this")
    }
    println(applyResult)
    println()
}

private fun alsoSample() {
    val person = Person(name = "Sam", age = 24)

    println("also")
    val alsoResult = person.also {
        println("$it")
        it.name = "Max"
        println("$it")
    }
    println(alsoResult)
    println()
}
