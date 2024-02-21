open class Vehiculo(private val marca: String,
                    private val modelo: String,
                    val capacidadCombustible: Float,
                    var combustibleActual: Float,
                    var kilometrosActuales: Float){

    init {
        requireAlgo(marca)
        requireAlgo(modelo)
        require(capacidadCombustible > 0) {"La capacidad del tanque debe ser mayor a 0."}
        require(combustibleActual in 0.0f..capacidadCombustible) {"El combustible actual no puede ser mayor a la capacidad de combustible"}
    }

    fun requireAlgo(valor: String){
        require(valor.isNotEmpty()){"Este campo no puede estar vacío"}
    }


    companion object {
        const val KM_POR_LITRO = 10
    }

    override fun toString(): String {
        return  "Marca $marca, modelo $modelo, capacidad tanque $capacidadCombustible, combustible actual: $combustibleActual, kilometraje actual: $kilometrosActuales"
    }

    fun obtenerInformacion(): String {
        return ("El vehículo puede recorrer ${calcularAutonomia()} km con $combustibleActual litros.")
    }

    open fun calcularAutonomia(): Int {
        return (combustibleActual * KM_POR_LITRO).toInt()
    }

    fun realizaViaje(distancia: Int): Int {
        if (combustibleActual > 0) {

            return distancia
        }else
    }

    fun repostar(cantidad: Float): Float {
        val combustiblePrevio = combustibleActual

        if (cantidad <= 0 )
            combustibleActual = capacidadCombustible
        return cantidad

    }
}