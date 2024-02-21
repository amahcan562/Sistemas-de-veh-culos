abstract class Vehiculo(
                    private val marca: String,
                    private val modelo: String,
                    val capacidadCombustible: Float,
                    var combustibleActual: Float,
                    var kilometrosActuales: Float) {

    init {
        requireAlgo(marca)
        requireAlgo(modelo)
        require(capacidadCombustible > .0f) { "La capacidad del tanque debe ser mayor a 0." }
        require(combustibleActual in .0f..capacidadCombustible) { "El combustible actual no puede ser mayor a la capacidad de combustible" }
    }

    fun requireAlgo(valor: String) {
        require(valor.isNotEmpty()) { "Este campo no puede estar vacío" }
    }


    companion object {
        const val KM_POR_LITRO = 10
    }

    override fun toString(): String {
        return "Marca $marca, modelo $modelo, capacidad tanque $capacidadCombustible, combustible actual: $combustibleActual, kilometraje actual: $kilometrosActuales"
    }

    fun obtenerInformacion(): String {
        return ("El vehículo puede recorrer ${calcularAutonomia()} km con $combustibleActual litros.")
    }

    open fun calcularAutonomia(): Float {
        return combustibleActual * KM_POR_LITRO
    }

    fun realizaViaje(distancia: Float): Float {
        if (distancia < calcularAutonomia()) {
            kilometrosActuales += distancia
            combustibleActual -= (distancia / KM_POR_LITRO).redondear(2)
            return .0f
        } else {
            val kilometros = calcularAutonomia()
            kilometrosActuales += kilometros
            combustibleActual = .0f
            return distancia - kilometros
        }
    }

    fun repostar(cantidad: Float): Float {
        if (cantidad <= 0) {
            println("Repostando al máximo...")
            combustibleActual = capacidadCombustible
            return combustibleActual.redondear(2)
        } else {
            println("Repostando $cantidad litros...")
            combustibleActual += cantidad
            return cantidad.redondear(2)
        }
    }
}