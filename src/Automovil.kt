class Automovil (
                nombre: String,
                marca: String,
                modelo: String,
                capacidadCombustible: Float,
                combustibleActual: Float,
                kilometrosActuales: Float,
                var esHibrido: Boolean)

                : Vehiculo(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales) {

    companion object{
        const val KM_POR_LITRO_HIBRIDO = 15.0f

        const val KM_AHORRO_HIBRIDO = 5f

        var condicionBritanica = false
            private set

        fun cambiarCondicionBritanica(nuevaCondicion: Boolean) {
            condicionBritanica = nuevaCondicion
        }
    }

    override fun calcularAutonomia(): Float {
        if (esHibrido)
            //return combustibleActual * KM_POR_LITRO_HIBRIDO
            return combustibleActual * (KM_POR_LITRO_GAS + KM_AHORRO_HIBRIDO)
        else
            return super.calcularAutonomia()
    }

    override fun actualizarCombustible(distancia: Float) {
        if (esHibrido)
            combustibleActual -= distancia / (KM_POR_LITRO_GAS + KM_AHORRO_HIBRIDO)
        else
            super.actualizarCombustible(distancia)

    }

    //TODO: CAMBIAR
    override fun toString() = "${super.toString()} , autonomia: " + this.calcularAutonomia()

}



