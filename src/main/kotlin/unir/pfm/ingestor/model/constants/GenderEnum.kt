package unir.pfm.ingestor.model.constants

enum class GenderEnum(
    val id: Long,
    val description: String
) {
    ZERO_CERTIFICATE(0,"Certificado cero"),
    ESCAPE(1,"Se fugó"),
    MEN(2,"Hombre"),
    WOMAN(3,"Mujer");

    companion object {
        fun getById(id: Long): GenderEnum = values().find { it.id == id }
            ?: GenderEnum.ZERO_CERTIFICATE
    }
}