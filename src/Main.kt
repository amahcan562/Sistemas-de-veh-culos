import kotlin.math.roundToInt

fun Float.redondear(posiciones: Int): Float{
    var factor = 1.0f
    for (i in 1..posiciones) factor *= 10

    return ((this * factor).toDouble().roundToInt() / factor)
}

fun main() {
    val coche = Automovil("c1", "Volkswagen","Golf", 50f, 40f, 0f, false)

    Automovil.cambiarCondicionBritanica(true)

    println(Automovil.condicionBritanica)

    val moto = Motocicleta("Kawasaki", "Ninja", 50, 300)

    println(coche.toString())
    println(moto.toString())
}
