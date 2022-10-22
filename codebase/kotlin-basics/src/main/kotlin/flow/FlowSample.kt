package flow

import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    // region collect

    // collect
    // collectFlow()

    // collectIndexedFlow
    // collectIndexedFlow()

    // collectLatest
    // collectLatestFlow()

    // endregion

    // region terminal

    // count
    // countFlow()

    // first
    // firstFlow()

    // firstOrNull
    // firstOrNullFlow()

    // last
    // lastFlow()

    // lastOrNull
    // lastOrNullFlow()

    // reduce
    // reduceFlow()

    // fold
    // foldFlow()

    // toList
    // toListFlow()

    // toSet
    // toSetFlow()

    // single
    // singleFlow()

    // singleOrNull
    // singleOrNullFlow()

    // endregion

    // region Other operators

    // filter
    // filterFlow()

    // filterNot
    // filterNotFlow()

    // filterNotNull
    // filterNotNullFlow()

    // filterIsInstance
    // filterIsInstanceFlow()

    // transform
    // transformFlow()

    // transformWhile
    // transformWhileFlow()

    // transformLatest
    transformLatestFlow()

    // map
    // mapFlow()

    // flatMapConcat
    // flatMapConcatFlow()

    // flatMapLatest
    // flatMapLatestFlow()

    // flatMapMerge
    // flatMapMergeFlow()

    // drop
    // dropFlow()

    // dropWhile
    // dropWhileFlow()

    // distinctUntilChanged
    // distinctUntilChangedFlow()

    // debounce
    // debounceFlow()

    // endregion
}
