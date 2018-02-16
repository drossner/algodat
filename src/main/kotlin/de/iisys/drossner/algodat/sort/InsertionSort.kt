package de.iisys.drossner.algodat.sort

import java.util.*

/**
 * created at 11.01.18
 * @author drossner
 */

fun insertionSort(a: IntArray): IntArray{
    for(j in 1 until  a.size-1){
        val key = a[j]
        var i = j - 1
        while (i >= 0 && a[i] > key){
            a[i+1] = a[i]
            i--
        }
        a[i+1] = key
    }
    return a
}

fun main(args: Array<String>) {
    val a = intArrayOf(3, 2, 1, 4)
    print(Arrays.toString(insertionSort(a)))
}