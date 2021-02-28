package unir.pfm.ingestor.model.constants

enum class SeatBeltEnum(
    val id: Long,
    val description: String
) {
    YES(7,"Sí"),
    NO(8,"No"),
    IGNORED(9,"Se ignora");

    companion object {
        fun getById(id: Long): SeatBeltEnum = values().find { it.id == id }
            ?: SeatBeltEnum.IGNORED
    }
}