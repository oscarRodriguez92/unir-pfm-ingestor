package unir.pfm.ingestor.db

import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import unir.pfm.ingestor.model.constants.ConfigProperty
import unir.pfm.ingestor.utils.Helper

class MongoClient {

    companion object {
        private val client = KMongo.createClient(
            Helper.loadProperty(ConfigProperty.DB_URL)
        )
        val database: MongoDatabase = client.getDatabase(
            Helper.loadProperty(ConfigProperty.DB_COLLECTION)
        )
    }
}