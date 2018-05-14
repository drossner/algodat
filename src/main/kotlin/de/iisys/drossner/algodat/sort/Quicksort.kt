package de.iisys.drossner.algodat.sort

import java.util.*

fun Random.randomList(length: Long, from: Int, to:Int): List<Int>{
    return this.ints(length, from, to).toArray().asList()
}

fun <T:Comparable<T>> quicksort(list: List<T>): List<T> =
        if(list.size < 2) list
        else {
            val (low, high) = list.subList(1, list.size).partition { it < list.first() }
            quicksort(low) + list.first() + quicksort(high)
        }

fun main(args: Array<String>) {
    quicksort(Random().randomList(20, 0, 99)).let { println(it) }
}