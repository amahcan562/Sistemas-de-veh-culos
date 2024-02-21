import kotlin.math.roundToInt

fun Float.redondear(posiciones: Int): Float{
    var factor = 1.0f
    for (i in 1..posiciones) factor *= 10

    return ((this * factor).toDouble().roundToInt() / factor)
}

fun main() {
    val coche = Automovil("Volkswagen","Golf", 50, "SUV")

    val moto = Motocicleta("Kawasaki", "Ninja", 50, 300)

    println(coche.toString())
    println(moto.toString())
}
