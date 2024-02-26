import kotlin.random.Random
class Carrera (val nombreCarrera: String,
                val distanciaTotal: Float,
                var participantes: List<Vehiculo>,
                var estadoCarrera: Boolean,
                var historialAcciones: MutableMap<String, MutableList<String>>,){

    fun iniciarCarrera(){
        estadoCarrera = true
        while(!estadoCarrera){
            TODO()
        }
        println("Carrera finalizada")
    }

    fun avanzarVehiculo(vehiculo: Vehiculo){
        if (vehiculo in participantes){
            var kilomentrosRandom = Random.nextFloat() * (190f) + 10.0f
            // Coche tiene que hacer un random - 150km
            var loopRealizarViaje = vehiculo.realizaViaje(kilomentrosRandom)
            // hacemos el viaje y nos dice que es distinto de cero, con lo cual sabemos que el viaje no se ha completado, si fuera cero es que el viaje se ha completado
            while (loopRealizarViaje != 0f){
                this.repostarVehiculo(vehiculo, 100f)
                // Como el viaje no lo hemos podido terminar, tenemos que echarle gasofa al coche, le metemos cien porque no tenemos una funcion que nos devuelva la cantidad del max del deposito
                // Mientras que no sea 0, es decir, no terminamos el recorrido
                val autonomia = vehiculo.calcularAutonomia()
                // Que autonomia teniamos
                kilomentrosRandom -= autonomia
                // Si teniamos que hacer 200 km, y el coche tenia una autonomia de 50 km, ahora tendremos que hacer 150
                loopRealizarViaje = vehiculo.realizaViaje(kilomentrosRandom)
                // Realizamos el viaje y verificamos que nos devuelve 0, si no, significa que el coche no ha podido completar el recorrido, y tendra que vovler a repostar y terminar la carrera.
            }

            val filigrana = Random.nextFloat()
            // Esto nos devuelve 0 o 1, trataremos el 1 como individual o 0 como dos filigranas, porque me sale de ahí
            if (filigrana == 1f){
                this.realizarFiligrana(vehiculo)
            } else{
                this.realizarFiligrana(vehiculo)
                this.realizarFiligrana(vehiculo)
            }
            //actualizarPosiciones(vehiculo)
            // este vehiculo ha recorrido la variable de arriba kilomentrosRandom
        }
    }

    fun repostarVehiculo(vehiculo: Vehiculo, cantidad: Float){
        vehiculo.repostar(cantidad)
        // Registro de repostaje
    }

    fun realizarFiligrana(vehiculo: Vehiculo){
        if(vehiculo.calcularAutonomia() == 0f){
            repostarVehiculo(vehiculo, 100f)
        }
        if (vehiculo is Automovil){
            vehiculo.realizarDerrape()
        }else if (vehiculo is Motocicleta){
            vehiculo.realizarCaballito()
        }


        // Registro de filigrana
    }
}