package de.iisys.drossner.algodat.sprachbeispiel

/**
 * created at 11.01.18
 * @author drossner
 */
//berechne n + n-1 + n-2 + ... + 1
fun main(args: Array<String>){
    val n = 3
    var ergebnis = 0
    for(i in n downTo  1){
        ergebnis += i
    }
    println(ergebnis)
}

//für Fortgeschrittene:
fun kuerzer(){
    val n = 3
    println( (n downTo 1).sum() )
}