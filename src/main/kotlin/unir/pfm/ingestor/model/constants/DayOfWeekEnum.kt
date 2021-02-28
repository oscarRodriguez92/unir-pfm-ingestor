package unir.pfm.ingestor.model.constants

enum class DayOfWeekEnum(
    val id: Long,
    val description: String
) {
    MONDAY(1,  "Lunes"),
    TUESDAY(2,  "Martes"),
    WEDNESDAY(3,  "Miercoles"),
    THURSDAY(4,  "Jueves"),
    FRIDAY(5,  "Viernes"),
    SATURDAY(6,  "Sabado"),
    SUNDAY(7,  "Domingo");

    companion object {
        fun getById(id: Long): DayOfWeekEnum = values().find { it.id == id }
            ?: throw Exception("Day of week not found by id:$id")
    }

}