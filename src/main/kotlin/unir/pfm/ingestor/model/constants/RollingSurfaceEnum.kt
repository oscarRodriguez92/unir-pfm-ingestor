package unir.pfm.ingestor.model.constants

enum class RollingSurfaceEnum(
    val id: Long,
    val description: String
) {
    ZERO_CERTIFICATE(0,"Certificado cero"),
    PAVED(1,"Pavimentada"),
    NOT_PAVED(2,"No pavimentada");

    companion object {
        fun getById(id: Long): RollingSurfaceEnum = values().find { it.id == id }
            ?: RollingSurfaceEnum.ZERO_CERTIFICATE
    }
}