class Motocicleta(nombre: String,
                  marca: String,
                  modelo: String,
                  capacidadCombustible: Float,
                  combustibleActual: Float,
                  kilometrosActuales: Float,
                  var cilindrada: Int): Vehiculo(nombre, marca, modelo, capacidadCombustible){

    companion object {
        const val KM_POR_LITRO_GAS = 20f
    }

    override fun calcularAutonomia(): Float {
        return combustibleActual * (KM_POR_LITRO_GAS - (1 - cilindrada/1000))
    }

    override fun toString() = "${super.toString()}, cilindrada: $cilindrada}, autonomia: " + this.calcularAutonomia()

    fun realizarCaballito(): Float{

    }

}