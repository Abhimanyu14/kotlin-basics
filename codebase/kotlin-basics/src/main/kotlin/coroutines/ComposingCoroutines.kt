package coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun doSomethingUsefulOne(data: Int): Int {
    delay(1000L) // pretend we are doing something useful here
    return data
}

fun main() {
    // sequential()

    // usingAsync()

    asyncLazyStart()
}

private fun sequential() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne(23)
        val two = doSomethingUsefulOne(34)
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")

}

private fun usingAsync() {
    runBlocking {
        val time = measureTimeMillis {
            val one = async { doSomethingUsefulOne(12) }
            val two = async { doSomethingUsefulOne(23) }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}

private fun asyncLazyStart() {
    runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne(12) }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne(13) }
            // some computation
            one.start() // start the first one
            two.start() // start the second one
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}
