package unir.pfm.ingestor.core.repository

import unir.pfm.ingestor.model.constants.ConfigProperty
import unir.pfm.ingestor.utils.Helper

class FindCityByStateIdAndCityIdCSVRepository {

    companion object {
        private val cityRepositoryPath = Helper.loadProperty(ConfigProperty.CSV_CITY_REPOSITORY)

        fun execute(stateId: Long, cityId: Long): String {
            val csvReader = Helper.buildCSVReader(cityRepositoryPath)
            var cityName = "";
            var line = csvReader.readNext()
            while (line != null) {
                if (line[0].toLong() == stateId && line[2].toLong() == cityId) {
                    cityName = line[3]
                    break
                }
                line = csvReader.readNext()
            }
            csvReader.close()
            if (cityName.isEmpty()) {
                throw Exception("City not found. [stateId: $stateId, cityId: $cityId]")
            }
            return cityName;
        }

    }
}