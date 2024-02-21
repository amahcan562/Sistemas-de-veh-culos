class Automovil (
                marca: String,
                modelo: String,
                capacidadCombustible: Float,
                combustibleActual: Float,
                kilometrosActuales: Float,
                private var tipo: String,
                esHibrido: Boolean,
                condicionBritanica: Boolean)

                : Vehiculo(marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales){

init {

}

override fun calcularAutonomia(): Float {
    return super.calcularAutonomia() + 100
}

override fun toString() = "${super.toString()}, tipo: $tipo} , autonomia: " + this.calcularAutonomia()
}