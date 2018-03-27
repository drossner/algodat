package de.iisys.drossner.algodat.rekursion

fun hanoi(n: Int, src: String, temp: String, target: String){
    //Abbruchbedingung
    if (n > 0){
        hanoi( n-1, src, target, temp )
        println("mv $src to $target") //Basisfall
        hanoi( n-1, temp, src, target )
    }
}

fun main(args: Array<String>) {
    hanoi(4, "a", "b", "c")
}