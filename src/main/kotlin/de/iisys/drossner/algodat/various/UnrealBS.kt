package de.iisys.drossner.algodat.various

fun bs(arr: IntArray, sw: Int): Int{
    var mitte = arr.size / 2
    while(true){
        //Thread.sleep(100);
        print(" $mitte ")
        if(arr[mitte] == sw) return mitte
        if(sw < arr[mitte]) mitte /= 2
        else mitte += mitte / 2
    }
}

fun main(args: Array<String>) {
    val arr = IntArray(11, {index -> index})
    //print(bs(arr, 9))
    for(i in 0 until arr.size){
        print("Search for $i:")
        if(i == 8 || i == 9) continue
        bs(arr, i)
        println()
    }
}