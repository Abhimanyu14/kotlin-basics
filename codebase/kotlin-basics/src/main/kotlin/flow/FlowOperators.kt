package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// Filter
suspend fun filterFlow() = coroutineScope {
    val flow = getCountDownFlow(10)

    launch {
        flow
            .filter {
                it % 2 == 0
            }
            .collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}

suspend fun filterNotFlow() = coroutineScope {
    val flow = getCountDownFlow(10)

    launch {
        flow
            .filterNot {
                it % 2 == 0
            }
            .collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}

suspend fun filterNotNullFlow() = coroutineScope {
    val flow = listOf(1, 2, null, 2, 3, 4, 5, null, 6).asFlow()

    launch {
        flow
            .filterNotNull()
            .collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}

suspend fun filterIsInstanceFlow() = coroutineScope {
    val flow = listOf(1, 2, null, 2, 3, 4, 5, null, 6, "Test").asFlow()

    launch {
        flow
            .filterIsInstance<Int>()
            .collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}


// Transform
suspend fun transformFlow() = coroutineScope {
    val flow = getCountDownFlow(10)

    launch {
        flow
            .transform {
                if (it % 2 == 0) {
                    emit(it)
                    emit(it / 2)
                }
            }.collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}

suspend fun transformWhileFlow() = coroutineScope {
    val flow = getCountDownFlow(10)

    launch {
        flow
            .transformWhile {
                if (it % 2 == 0) {
                    emit(it)
                    emit(it / 2)
                    true
                } else {
                    false
                }
            }.collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun transformLatestFlow() = coroutineScope {
    val flow = getExponentialCountDownFlow(10, 20)

    launch {
        flow
            .transformLatest {
                if (it % 2 == 0) {
                    emit(it)
                    delay(100)
                    emit(it)
                }
            }.collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}


// Map
suspend fun mapFlow() = coroutineScope {
    val flow = getCountDownFlow(10)

    launch {
        flow
            .map {
                it * 10
            }.collect {
                println("C: $it")
                println()
                delay(100L)
            }
    }
}

@OptIn(FlowPreview::class)
suspend fun flatMapConcatFlow() = coroutineScope {
    val flow = getCountDownFlow(2, 200, 1)
    val flow2 = getCountDownFlow(3, 300, 2)

    launch {
        flow
            .flatMapConcat {
                flow2
            }.collect {
                println("C: $it")
                println()
            }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun flatMapLatestFlow() = coroutineScope {
    val flow = getCountDownFlow(2, 500, 1)
    val flow2 = getCountDownFlow(3, 200, 2)

    launch {
        flow
            .flatMapLatest {
                flow2
            }.collect {
                println("C: $it")
                println()
            }
    }
}

@OptIn(FlowPreview::class)
suspend fun flatMapMergeFlow() = coroutineScope {
    val flow = getCountDownFlow(2, 500, 1)
    val flow2 = getCountDownFlow(3, 200, 2)

    launch {
        flow
            .flatMapMerge {
                flow2
            }.collect {
                println("C: $it")
                println()
            }
    }
}

// Drop
suspend fun dropFlow() = coroutineScope {
    val flow = getCountDownFlow(5, 500, 1)

    launch {
        flow
            .drop(3)
            .collect {
                println("C: $it")
                println()
            }
    }
}

suspend fun dropWhileFlow() = coroutineScope {
    val flow = listOf(2, 4, 5, 6, 9, 10, 11).asFlow()

    launch {
        flow
            .onEach {
                println("E: $it")
            }
            .dropWhile {
                it % 2 == 0
            }
            .collect {
                println("C: $it")
                println()
            }
    }
}


suspend fun distinctUntilChangedFlow() = coroutineScope {
    val flow = listOf(1, 1, 1, 2, 2, 1, 2, 3, 4, 5, 4, 3, 3, 4).asFlow()

    launch {
        flow
            .onEach {
                println("E: $it")
            }
            .distinctUntilChanged()
            .collect {
                println("C: $it")
                println()
            }
    }
}


@OptIn(FlowPreview::class)
suspend fun debounceFlow() = coroutineScope {
    val flow = getExponentialCountDownFlow(10)

    launch {
        flow
            .debounce(1000)
            .collect {
                println("C: $it")
                println()
            }
    }
}
