class Motocicleta(nombre: String,
                  marca: String,
                  modelo: String,
                  capacidadCombustible: Float,
                  combustibleActual: Float,
                  kilometrosActuales: Float,
                  var cilindrada: Int)

              : Vehiculo(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales){

    init {
        require(cilindrada in 125..1000) {"El valor debe ser entre 125 y 1000 cc."}
    }

    companion object {
        const val KM_POR_LITRO_GAS = 20f
    }

    override fun calcularAutonomia(): Float {
        return combustibleActual * (KM_POR_LITRO_GAS - (1 - cilindrada/1000))
    }

    override fun toString() = "${super.toString()}, cilindrada: $cilindrada, autonomia: " + this.calcularAutonomia() + "km."

    fun realizarCaballito(): Float{
        actualizarCombustible(6.5f)
        return combustibleActual
    }

}