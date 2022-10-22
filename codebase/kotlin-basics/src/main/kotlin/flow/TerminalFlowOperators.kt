package flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

suspend fun countFlow() = coroutineScope {
    val flow = getCountDownFlow(10, 10)

    launch {
        val result = flow
            .count {
                it % 4 == 0
            }

        println("Count of numbers divisible by 3: $result")
    }
}

suspend fun firstFlow() = coroutineScope {
    val flow = getCountDownFlow(2, 500, 1)

    launch {
        val result = flow.first()
        println("First $result")
    }
}

suspend fun firstOrNullFlow() = coroutineScope {
    val flow = getCountDownFlow(2, 500, 1)

    launch {
        val result = flow.firstOrNull()
        println("firstOrNull $result")
    }
}

suspend fun lastFlow() = coroutineScope {
    val flow = getCountDownFlow(2, 500, 1)

    launch {
        val result = flow.last()
        println("Last $result")
    }
}

suspend fun lastOrNullFlow() = coroutineScope {
    val flow = getCountDownFlow(2, 500, 1)

    launch {
        val result = flow.lastOrNull()
        println("lastOrNull $result")
    }
}

suspend fun reduceFlow() = coroutineScope {
    val flow = getCountDownFlow(10, 10)

    launch {
        val result = flow
            .reduce { accumulator, value ->
                accumulator + value
            }

        println("Sum: $result")
    }
}

suspend fun foldFlow() = coroutineScope {
    val flow = getCountDownFlow(10, 10)

    launch {
        val result = flow
            .fold(5) { accumulator, value ->
                accumulator + value
            }

        println("Sum + 5: $result")
    }
}

suspend fun toListFlow() = coroutineScope {
    val flow = getCountDownFlow(10, 10)

    launch {
        val result = flow.toList()

        println("List: $result")
    }
}

suspend fun toSetFlow() = coroutineScope {
    val flow = getCountDownFlow(10, 10)

    launch {
        val result = flow.toSet()

        println("Set: $result")
    }
}

suspend fun singleFlow() = coroutineScope {
    val flow = getCountDownFlow(1, 10)

    launch {
        val result = flow.single()

        println("single: $result")
    }
}

suspend fun singleOrNullFlow() = coroutineScope {
    val flow = getCountDownFlow(1, 10)

    launch {
        val result = flow.singleOrNull()

        println("single: $result")
    }
}
