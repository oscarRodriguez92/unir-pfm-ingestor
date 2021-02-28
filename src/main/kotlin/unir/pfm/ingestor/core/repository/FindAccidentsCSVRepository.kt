package unir.pfm.ingestor.core.repository

import unir.pfm.ingestor.core.use_case.ConvertCsvRowToAccident
import unir.pfm.ingestor.core.use_case.ValidateAccidentRow
import unir.pfm.ingestor.model.db.Accident
import unir.pfm.ingestor.utils.Helper
import java.io.File

class FindAccidentsCSVRepository {

    companion object {
        fun execute(csvFile: File): List<Accident> {
            val accidents = mutableListOf<Accident>()
            val csvReader = Helper.buildCSVReader(csvFile)

            var row: Array<String>? = csvReader.readNext()
            while (row != null) {
                if (ValidateAccidentRow.execute(row)) {
                    val accident = ConvertCsvRowToAccident.execute(row)
                    accidents.add(accident)
                }
                row = csvReader.readNext()
            }
            csvReader.close()
            return accidents
        }
    }
}