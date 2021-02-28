package unir.pfm.ingestor.model.constants

enum class AlcoholicBreathEnum(
    val id: Long,
    val description: String
) {
    YES(4,"Sí"),
    NO(5,"No"),
    IGNORED(6,"Se ignora");

    companion object {
        fun getById(id: Long): AlcoholicBreathEnum = values().find { it.id == id }
            ?: AlcoholicBreathEnum.IGNORED
    }
}