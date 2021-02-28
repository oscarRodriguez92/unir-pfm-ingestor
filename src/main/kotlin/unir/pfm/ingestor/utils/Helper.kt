package unir.pfm.ingestor.utils

import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import unir.pfm.ingestor.model.constants.ConfigProperty
import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import java.util.*

class Helper {

    companion object {

        private val prop = Properties()

        init {
            val fis = this.javaClass.classLoader.getResourceAsStream("config.properties")
            prop.load(fis)
        }

        fun loadProperty(property: ConfigProperty): String =
            prop.getProperty(property.propertyName)

        fun getCsvFiles(folderPath: String): List<File> =
            File(folderPath).walk()
                .filter { file ->
                    file.extension.toLowerCase() == "csv"
                }.toList()

        fun buildCSVReader(csv: File): CSVReader =
            CSVReaderBuilder(
                FileReader(csv, Charset.forName("UTF-8"))
            )
                .withSkipLines(1)
                .build()

        fun buildCSVReader(csv: String): CSVReader =
            CSVReaderBuilder(
                FileReader(csv, Charset.forName("UTF-8"))
            )
                .withSkipLines(1)
                .build()

    }
}