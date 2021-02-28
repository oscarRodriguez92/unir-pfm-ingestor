package unir.pfm.ingestor.model.constants

enum class ConfigProperty(
    val propertyName: String
) {
    DB_URL("db.url"),
    DB_COLLECTION("db.collection"),
    CSV_ACCIDENTS_REPOSITORIES_PATH("csv.accidents.repositories.path"),
    CSV_CITY_REPOSITORY("csv.city.repository.path");
}