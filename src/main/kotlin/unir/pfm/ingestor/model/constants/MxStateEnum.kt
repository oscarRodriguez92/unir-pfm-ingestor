package unir.pfm.ingestor.model.constants

enum class MxStateEnum(
    val id: Long,
    val externalId: Long,
    val description: String
) {
    AGUASCALIENTES(1, 1804, "Aguascalientes"),
    BAJA_CALIFORNIA(2, 1805, "Baja California"),
    BAJA_CALIFORNIA_SUR(3, 1806, "Baja California Sur"),
    CAMPECHE(4, 1807, "Campeche"),
    COAHUILA(5, 1810, "Coahuila"),
    COLIMA(6, 1811, "Colima"),
    CHIAPAS(7, 1808, "Chiapas"),
    CHIHUAHUA(8, 1809, "Chihuahua"),
    DISTRITO_FEDERAL(9, 1812, "Distrito Federal"),
    DURANGO(10, 1813, "Durango"),
    GUANAJUATO(11, 1814, "Guanajuato"),
    GUERRERO(12, 1815, "Guerrero"),
    HIDALGO(13, 1816, "Hidalgo"),
    JALISCO(14, 1817, "Jalisco"),
    MEXICO(15, 1818, "México"),
    MICHOACAN(16, 1819, "Michoacán"),
    MORELOS(17, 1820, "Morelos"),
    NAYARIT(18, 1821, "Nayarit"),
    NUEVO_LEON(19, 1822, "Nuevo León"),
    OAXACA(20, 1823, "Oaxaca"),
    PUEBLA(21, 1824, "Puebla"),
    QUERETARO(22, 1825, "Querétaro"),
    QUINTANA_ROO(23, 1826, "Quintana Roo"),
    SAN_LUIS_POTOSI(24, 1827, "San Luis Potosí"),
    SINALOA(25, 1828, "Sinaloa"),
    SONORA(26, 1829, "Sonora"),
    TABASCO(27, 1830, "Tabasco"),
    TAMAULIPAS(28, 1831, "Tamaulipas"),
    TLAXCALA(29, 1832, "Tlaxcala"),
    VERACRUZ(30, 1833, "Veracruz"),
    YUCATAN(31, 1834, "Yucatán"),
    ZACATECAS(32, 1835, "Zacatecas");

    companion object {
        fun getById(id: Long): MxStateEnum = values().find { it.id == id }
            ?: throw Exception("State not found by id:$id")
    }

}