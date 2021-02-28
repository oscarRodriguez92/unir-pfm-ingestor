package unir.pfm.ingestor.core.use_case

import unir.pfm.ingestor.model.constants.DayOfWeekEnum

class ValidateAccidentRow {

    companion object {
        fun execute (row: Array<String>) : Boolean{
            var valid = true
            val dayOfWeekId = row[7].toLong() // DIASEMANA
            try {
                DayOfWeekEnum.getById(dayOfWeekId)
            } catch (ex: Exception) {
                println("WARN: ${ex.message}")
                valid = false
            }
            return valid
        }
    }
}