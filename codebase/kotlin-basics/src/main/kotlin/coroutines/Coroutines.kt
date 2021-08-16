package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    // First
    runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello 1") // coroutines.main coroutine continues while a previous one is delayed
    }

    // Second
    runBlocking { // this: CoroutineScope
        launch { doWorld2() }
        println("Hello 2")
    }

    // Third
    runBlocking {
        doWorld3()
    }

    // Fourth
    runBlocking {
        doWorld4()
    }

    // Fifth
    // Sequentially executes coroutines.doWorld followed by "Done"
    runBlocking {
        doWorld5()
        println("Done")
    }

    // Sixth
    runBlocking {
        doWorld6()
    }

    // Seventh
    runBlocking {
        repeat(5) { // launch a lot of coroutines at the same time
            launch {
                delay(1000L)
                println("REPEAT")
            }
        }
    }

    runBlocking {
        repeat(1) {

        }
    }
}

// this is your first suspending function
suspend fun doWorld2() {
    delay(1000L)
    println("World!")
}

suspend fun doWorld3() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello 3")
}

// launch can not be directly used in suspend functions
suspend fun doWorld4() {
    // launch { // Unresolved reference launch
    delay(1000L)
    println("World!")
    // }
    println("Hello 4")
}

// Concurrently executes both sections
suspend fun doWorld5() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello 5")
}

// Concurrently executes both sections
suspend fun doWorld6() = coroutineScope { // this: CoroutineScope
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello 6")
    job.join() // wait until child coroutine completes
    println("Done")
}

