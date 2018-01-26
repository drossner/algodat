package de.iisys.drossner.algodat.ggt

/**
 * created at 26.01.18
 * @author drossner
 */

fun gcd(p: Int, q: Int): Int = if(q == 0) p else gcd(q, p % q)