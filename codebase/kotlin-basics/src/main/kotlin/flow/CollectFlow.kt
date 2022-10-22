package flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

suspend fun collectFlow() = coroutineScope {
    val flow = getCountDownFlow()

    // collect
    launch {
        flow.collect {
            println("C: $it")
            println()
            delay(100L)
        }
    }
}

suspend fun collectIndexedFlow() = coroutineScope {
    val flow = getCountDownFlow()

    // collect
    launch {
        flow.collectIndexed { index, value ->
            println("C: Index $index Value $value")
            println()
            delay(100L)
        }
    }
}

suspend fun collectLatestFlow() = coroutineScope {
    val flow = getCountDownFlow()

    // collect latest
    launch {
        flow.collectLatest {
            println("C: $it")
            println()
            delay(600L)
        }
    }
}
