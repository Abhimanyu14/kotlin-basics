package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

fun getCountDownFlow(
    startingValue: Int = 3,
    delayMillis: Long = 300L,
    id: Int = 1,
): Flow<Int> {
    return flow {
        var currentValue = startingValue
        while (currentValue > 0) {
            delay(delayMillis)
            println("E$id: $currentValue")
            emit(currentValue)
            currentValue--
        }
    }
}

fun getExponentialCountDownFlow(
    startingValue: Int = 3,
    delayMillis: Long = 300L,
    id: Int = 1,
): Flow<Int> {
    return flow {
        var currentValue = startingValue
        while (currentValue > 0) {
            delay(delayMillis * currentValue)
            println("E$id: $currentValue")
            emit(currentValue)
            currentValue--
        }
    }
}

val alphabetsFlow = ('a'..'z').asFlow()
