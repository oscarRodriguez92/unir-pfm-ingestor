package unir.pfm.ingestor.model.constants

enum class AccidentTypeEnum(
    val id: Long,
    val description: String
) {
    COLLISION_WITH_VEHICLE(1,"Colisión con vehículo automotor"),
    COLLISION_WITH_PERSON(2,"Colisión con peatón (atropellamiento)"),
    COLLISION_WITH_ANIMAL(3,"Colisión con animal"),
    COLLISION_WITH_STATIC_OBJECT(4,"Colisión con objeto fijo"),
    ROLLOVER(5,"Volcadura"),
    PASSENGER_DROP(6,"Caída de pasajero"),
    WAY_OUT(7,"Salida del camino"),
    FIRE(8,"Incendio"),
    COLLISION_WITH_RAIL(9,"Colisión con ferrocarril"),
    COLLISION_WITH_MOTORCYCLE(10,"Colisión con motocicleta"),
    COLLISION_WITH_CYCLIST(11,"Colisión con ciclista"),
    OTHER(12,"Otro");

    companion object {
        fun getById(id: Long): AccidentTypeEnum = values().find { it.id == id }
            ?: AccidentTypeEnum.OTHER
    }

}