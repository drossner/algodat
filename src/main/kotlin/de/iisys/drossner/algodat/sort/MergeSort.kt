package de.iisys.drossner.algodat.sort

import java.util.*

fun mergesort(a: IntArray, start: Int, end: Int){
    if (start < end - 1) {
        val mid = (start + end) / 2
        mergesort(a, start, mid)
        mergesort(a, mid, end)
        merge(a, start, mid, end)
    }
}

fun merge(a: IntArray, start: Int, mid: Int, end: Int){
    val tempa = IntArray(mid - start, {index -> a[index + start]})
    val tempb = IntArray(end - mid, {index -> a[index + mid]})

    var aIndex = 0
    var bIndex = 0

    for (k in start until end){
        a[k] =
                if (tempa.getOrElse(aIndex, {Int.MAX_VALUE}) <= tempb.getOrElse(bIndex, {Int.MAX_VALUE})){
                    tempa[aIndex++]
                } else {
                    tempb[bIndex++]
                }
    }
}

fun main(args: Array<String>) {
    val test = intArrayOf(10, 1, 18, 86, 12, 3, 8, 81, 22, 13, 4, 20, 21, 36)
    mergesort(test, 0, test.size)
    println(Arrays.toString(test))
}