package unir.pfm.ingestor.core.use_case

import unir.pfm.ingestor.model.db.Accident

class ConvertCsvRowToAccident {

    companion object {
        fun execute(row: Array<String>): Accident {
            val carsNum = row[11].toLong() // AUTOMOVIL
            val railwaysNum = row[20].toLong() // FERROCARRI
            val motorcyclesNum = row[21].toLong() // MOTOCICLET
            val bikesNum = row[22].toLong() // BICICLETA

            val busesNum = row[12].toLong() + // CAMPASAJ
                    row[13].toLong() + // MICROBUS
                    row[14].toLong() + // PASCAMION
                    row[15].toLong() + // OMNIBUS
                    row[16].toLong() // TRANVIA

            val trucksNumber = row[17].toLong() + // CAMIONETA
                    row[18].toLong() + // CAMION
                    row[19].toLong() // TRACTOR

            val totalVehicles = carsNum + railwaysNum + motorcyclesNum + bikesNum + busesNum + trucksNumber

            val numOfDead = row[30].toLong() + // CONDMUERTO
                    row[32].toLong() + // PASAMUERTO
                    row[34].toLong() + // PEATMUERTO
                    row[36].toLong() + // CICLMUERTO
                    row[38].toLong() // OTROMUERTO

            val numOfInjured = row[31].toLong() + // CONDHERIDO
                    row[33].toLong() + // PASAHERIDO
                    row[35].toLong() + // PEATHERIDO
                    row[37].toLong() + // CICLHERIDO
                    row[39].toLong() // OTROHERIDO

                    return Accident(
                        stateId = row[0].toLong(), // EDO
                        cityId = row[3].toLong(), // MPIO
                        month = row[1].toLong(), // MES
                        year = row[2].toLong(), // ANIO
                        hour = row[4].toLong(), // HORA
                        minute = row[5].toLong(), // MINUTOS
                        day = row[6].toLong(), // DIA
                        dayOfWeekId = row[7].toLong(), // DIASEMANA
                        accidentTypeId = row[10].toLong(), // TIPACCID
                        accidentCauseId = row[24].toLong(), // CAUSAACCI
                        rollingSurfaceId = row[25].toLong(), // CAPAROD
                        genderId = row[26].toLong(), // SEXO
                        alcoholicBreathId = row[27].toLong(), // ALIENTO
                        seatBeltId = row[28].toLong(), // CINTURON
                        age = row[29].toLong(), // EDAD
                        carsNum = carsNum,
                        railwaysNum = railwaysNum,
                        motorcyclesNum = motorcyclesNum,
                        bikesNum = bikesNum,
                        busesNum = busesNum,
                        trucksNumber = trucksNumber,
                        totalVehicles = totalVehicles,
                        numOfDead = numOfDead,
                        numOfInjured = numOfInjured
                    )
        }
    }
}