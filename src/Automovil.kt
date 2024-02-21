class Automovil (marca: String, modelo: String, capacidadCombustible: Float, private var tipo: String, combustibleActual: Float, kilometrosActuales: Int
): Vehiculo(marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales){

    override fun calcularAutonomia(): Int {
        return super.calcularAutonomia() + 100
    }

    override fun toString() = "${super.toString()}, tipo: $tipo} , autonomia: " + this.calcularAutonomia()
}