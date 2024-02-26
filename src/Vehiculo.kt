abstract class Vehiculo(
                    val nombre: String,
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
        require(esNombreUnico(nombre) && nombre.isNotBlank()) {"El valor $nombre ya existe."}
    }

    fun requireAlgo(valor: String) {
        require(valor.isNotEmpty()) { "Este campo no puede estar vacío" }
    }


    companion object {
        const val KM_POR_LITRO_GAS = 10f

        private val nombres : MutableSet<String> = mutableSetOf()

        private fun esNombreUnico(nombre: String) : Boolean {
            return nombres.add(nombre)
        }
    }

    override fun toString(): String {
        return "Nombre: $nombre, Marca $marca, modelo $modelo, capacidad tanque $capacidadCombustible, combustible actual: $combustibleActual, kilometraje actual: $kilometrosActuales"
    }

    fun obtenerInformacion(): String {
        return ("El vehículo puede recorrer ${calcularAutonomia()} km con $combustibleActual litros.")
    }

    open fun calcularAutonomia(): Float {
        return combustibleActual * KM_POR_LITRO_GAS
    }

    fun realizaViaje(distancia: Float): Float {
        //val distanciaARecorrer = minOf(calcularAutonomia(), distancia)

        val distanciaARecorrer: Float
        val distanciaTotal = this.calcularAutonomia()

        if (distancia < distanciaTotal) {
            distanciaARecorrer = distancia
        }
        else {
            distanciaARecorrer = distanciaTotal
        }
        //println("Distancia a recorrer $distanciaARecorrer")
        this.actualizarCombustible(distanciaARecorrer)
        this.actualizarKilometros(distanciaARecorrer)

        return distancia - distanciaARecorrer

    }

    private fun actualizarKilometros(distancia: Float) {
        kilometrosActuales += distancia
    }

    protected open fun actualizarCombustible(distancia: Float) {
        combustibleActual -= distancia / KM_POR_LITRO_GAS
        if (combustibleActual < 0){
            combustibleActual = 0f
        }
    }

    fun repostar(cantidad: Float = 0f): Float {
        val combustibleAntesRepostar = combustibleActual

        if (cantidad <= 0 && cantidad + combustibleActual > capacidadCombustible) {
            println("Repostando al máximo...")
            combustibleActual = capacidadCombustible

        } else {
            println("Repostando $cantidad litros...")
            combustibleActual += cantidad
        }

        return combustibleActual - combustibleAntesRepostar
    }
}