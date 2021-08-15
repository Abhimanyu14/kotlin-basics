package generics

interface Contract {
    fun canWork(): Boolean
}

open class Mammal() {
    var name: String = ""

    constructor(name: String) : this() {
        this.name = name
    }
}

class Human : Mammal(), Contract {
    fun setParentName(name: String) {
        this.name = name
    }

    override fun canWork(): Boolean {
        println("humans can work")
        return true
    }
}

class Elephant : Mammal() {
    fun setParentName(name: String) {
        this.name = name
    }
}

fun <T : Mammal> printMammalName(mammal: T) {
    println(mammal.name)
    // mammal.canWork()
}

fun main() {
    val human = Human()
    human.setParentName("human")
    val elephant = Elephant()
    elephant.setParentName("elephant")

    printMammalName(human)
    printMammalName(elephant)
}
