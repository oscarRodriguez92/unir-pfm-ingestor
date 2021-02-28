package unir.pfm.ingestor.core.use_case

import unir.pfm.ingestor.core.repository.FindAccidentsCSVRepository
import org.litote.kmongo.getCollection
import unir.pfm.ingestor.db.MongoClient
import unir.pfm.ingestor.model.constants.ConfigProperty
import unir.pfm.ingestor.model.db.Accident
import unir.pfm.ingestor.utils.Helper

class LoadAndSaveAccidents {

    companion object {
        private const val insertBatchSize = 20000
    }

    fun execute() {
        var totalAccidents = 0
        val accidentCollection = MongoClient.database.getCollection<Accident>()
        Helper.getCsvFiles(
            Helper.loadProperty(ConfigProperty.CSV_ACCIDENTS_REPOSITORIES_PATH)
        )
            .forEach { csvFile ->
                val accidents = FindAccidentsCSVRepository.execute(csvFile)
                totalAccidents += accidents.size
                println("Accidents: ${accidents.size}")
                val accidentsBatchArr = accidents.windowed(insertBatchSize, insertBatchSize, true)
                accidentsBatchArr.forEach { accidentsBatch ->
                    println("MongoDB insertMany: ${accidentsBatch[0].stateName}")
                    accidentCollection.insertMany(accidentsBatch)
                }
            }

        println("totalAccidents: $totalAccidents")
    }
}