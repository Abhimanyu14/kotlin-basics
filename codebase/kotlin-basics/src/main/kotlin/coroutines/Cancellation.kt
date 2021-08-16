package coroutines

import kotlinx.coroutines.*

var acquired = 0

// Mocking a resurce
class Resource {
    init {
        acquired++
    } // Acquire the resource

    fun close() {
        acquired--
    } // Release the resource
}

fun main() {
    // cancel demo
    runBlocking {
        // cancelDemo1()
    }

    // non-cooperative
    runBlocking {
        // cancelDemo2()
    }

    // cooperative
    runBlocking {
        // cancelDemo3()
    }

    // handling cancellation exception
    runBlocking {
        // cancelDemo4()
    }

    // non cancellable block
    runBlocking {
        // cancelDemo5()
    }

    // withTimeout
    runBlocking {
        // cancelDemo6()
    }

    // withTimeoutOrNull
    runBlocking {
        // cancelDemo7()
    }

    // setTimeout leaking resources
    runBlocking {
        // cancelDemo8()
    }

    // without leaking resources
    runBlocking {
        cancelDemo9()
    }
}

// launch can not be directly used in suspend functions
suspend fun cancelDemo1() = coroutineScope {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
}

// continues execution
suspend fun cancelDemo2() = coroutineScope {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // computation loop, just wastes CPU
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

suspend fun cancelDemo3() = coroutineScope {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // cancellable computation loop
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

suspend fun cancelDemo4() = coroutineScope {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

suspend fun cancelDemo5() = coroutineScope {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

suspend fun cancelDemo6() = coroutineScope {
    withTimeout(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
}

suspend fun cancelDemo7() = coroutineScope {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done" // will get cancelled before it produces this result
    }
    println("Result is $result")
}

suspend fun cancelDemo8() = coroutineScope {
    repeat(100_000) { // Launch 100K coroutines
        launch {
            val resource = withTimeout(60) { // Timeout of 60 ms
                delay(50) // Delay for 50 ms
                Resource() // Acquire a resource and return it from withTimeout block
            }
            resource.close() // Release the resource
        }
    }

    // Outside of runBlocking all coroutines have completed
    println(acquired) // Print the number of resources still acquired
}

suspend fun cancelDemo9() = coroutineScope {
    repeat(100_000) { // Launch 100K coroutines
        launch {
            var resource: Resource? = null // Not acquired yet
            try {
                withTimeout(60) { // Timeout of 60 ms
                    delay(50) // Delay for 50 ms
                    resource = Resource() // Store a resource to the variable if acquired
                }
                // We can do something else with the resource here
            } finally {
                resource?.close() // Release the resource if it was acquired
            }
        }
    }
    // Outside of runBlocking all coroutines have completed
    println(acquired) // Print the number of resources still acquired
}
