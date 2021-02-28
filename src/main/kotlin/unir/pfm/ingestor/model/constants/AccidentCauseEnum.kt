package unir.pfm.ingestor.model.constants

enum class AccidentCauseEnum(
    val id: Long,
    val description: String
) {
    DRIVER(1,"Conductor"),
    WALKER_OR_PASSENGER(2,"Peatón o pasajero"),
    VEHICLE_FAILURE(3,"Falla del vehículo"),
    POOR_CONDITION_OF_THE_ROAD(4,"Mala condición del camino"),
    OTHER(5,"Otra");

    companion object {
        fun getById(id: Long): AccidentCauseEnum = values().find { it.id == id }
            ?: AccidentCauseEnum.OTHER
    }
}