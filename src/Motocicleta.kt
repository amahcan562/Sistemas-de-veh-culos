class Motocicleta(marca: String, modelo: String, capacidadCombustible: Int, var cilindrada: Int): Vehiculo(marca, modelo, capacidadCombustible){

    override fun calcularAutonomia(): Int {
        return super.calcularAutonomia() - 40
    }

    override fun toString() = "${super.toString()}, cilindrada: $cilindrada}, autonomia: " + this.calcularAutonomia()

}