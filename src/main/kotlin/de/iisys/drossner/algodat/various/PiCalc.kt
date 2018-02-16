package de.iisys.drossner.algodat.various

import kotlin.math.pow

/**
 * created at 14.02.18
 * @author drossner
 */

//Annahme:
//Fläche Kreis = PI * r^2
//Fläche Rechteck = (2r)^2
//Kreis mit r = 1 in Rechteck mit Kanten = 2
//Kreisfläche = PI = KF
//Rechteckfläche = 4 = RF
//Punkte in Rechteck / Punkte in Kreis = 4 / PI
//PI = 4*PIK / PIR
//PIR = rounds
fun calcPi(rounds: Long): Double{
    val middle = Point(1.0, 1.0)
    var i = rounds
    var inCirc = 0L
    while(i-- > 0){
        val point = Point(Math.random()*2, Math.random()*2)
        if(calcDist(middle, point) <= 1.0) inCirc++
    }

    return (4*inCirc)/rounds.toDouble()
}


fun calcDist(a: Point, b: Point) = Math.sqrt( (a.x - b.x).pow(2) + (a.y - b.y).pow(2) )
data class Point(val x: Double, val y: Double)

fun main(args: Array<String>) {
    println(calcPi(100_000_000))
}