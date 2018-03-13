package de.iisys.drossner.algodat.rekursion

/**
 * n ist eine natürliche Zahl
 */
fun fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)

fun main(args: Array<String>) {
    println(fac(5))
}
