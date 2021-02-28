package unir.pfm.ingestor.model.db

import unir.pfm.ingestor.core.repository.FindCityByStateIdAndCityIdCSVRepository
import unir.pfm.ingestor.model.constants.*
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId

data class Accident private constructor(
    val stateId: Long, // Entidad Federativa
    val stateName: String,
    val stateExternalId: Long,

    val cityId: Long,
    val cityName: String,

    val month: Long, // Mes en que ocurrió el accidente
    val year: Long, // Año de estudio
    val hour: Long,
    val minute: Long,
    val day: Long,
    val dayOfWeek: String,
    val date: OffsetDateTime,

    val accidentTypeId: Long, // Tipo de accidente
    val accidentTypeDesc: String,

    val accidentCauseId: Long, // Causa determinante o presunta del accidente
    val accidentCauseDesc: String,

    val rollingSurface: String, // Superficie de rodamiento

    val genderId: Long, // Sexo del conductor presunto responsable
    val genderDesc: String,

    val alcoholicBreathId: Long, // Aliento alcohólico
    val alcoholicBreathDesc: String,

    val seatBeltId: Long, // Uso del cinturón de seguridad
    val seatBeltDesc: String,

    val age: Long, // Se refiere a la edad del conductor responsable

    val carsNum: Long, // Núm. de Automóviles
    val railwaysNum: Long, // Núm. de Ferrocarriles
    val motorcyclesNum: Long, // Núm. de Motocicletas
    val bikesNum: Long, // Núm. de Bicicletas

    val busesNum: Long, // vehículos para transportar pasajeros
    val trucksNumber: Long, // Núm. de vehículos de carga

    val totalVehicles: Long, // Núm. total de vehículos involucrados

    val numOfDead: Long, // Núm. de de muertos
    val numOfInjured: Long, // Núm. de heridos
    val fatalAccident: Boolean // True si hubo muertos
) {
    constructor(
        stateId: Long,
        cityId: Long,
        month: Long,
        year: Long,
        hour: Long,
        minute: Long,
        day: Long,
        dayOfWeekId: Long,
        accidentTypeId: Long,
        accidentCauseId: Long,
        rollingSurfaceId: Long,
        genderId: Long,
        alcoholicBreathId: Long,
        seatBeltId: Long,
        age: Long,
        carsNum: Long,
        railwaysNum: Long,
        motorcyclesNum: Long,
        bikesNum: Long,
        busesNum: Long,
        trucksNumber: Long,
        totalVehicles: Long,
        numOfDead: Long,
        numOfInjured: Long
    ) : this(
        stateId = stateId,
        stateName = MxStateEnum.getById(stateId).description,
        stateExternalId = MxStateEnum.getById(stateId).externalId,
        cityId = cityId,
        cityName = FindCityByStateIdAndCityIdCSVRepository.execute(stateId, cityId),
        month = month,
        year = year,
        hour = hour,
        minute = minute,
        day = day,
        dayOfWeek = DayOfWeekEnum.getById(dayOfWeekId).description,
        date = LocalDateTime.of(year.toInt(), month.toInt(), day.toInt(), hour.toInt(), minute.toInt(), 0)
            .atZone(ZoneId.systemDefault())
            .toOffsetDateTime(),
        accidentTypeId = accidentTypeId,
        accidentTypeDesc = AccidentTypeEnum.getById(accidentTypeId).description,
        accidentCauseId = accidentCauseId,
        accidentCauseDesc = AccidentCauseEnum.getById(accidentCauseId).description,
        rollingSurface = RollingSurfaceEnum.getById(rollingSurfaceId).description,
        genderId = genderId,
        genderDesc = GenderEnum.getById(genderId).description,
        alcoholicBreathId = alcoholicBreathId,
        alcoholicBreathDesc = AlcoholicBreathEnum.getById(alcoholicBreathId).description,
        seatBeltId = seatBeltId,
        seatBeltDesc = SeatBeltEnum.getById(seatBeltId).description,
        age = age,
        carsNum = carsNum,
        railwaysNum = railwaysNum,
        motorcyclesNum = motorcyclesNum,
        bikesNum = bikesNum,
        busesNum = busesNum,
        trucksNumber = trucksNumber,
        totalVehicles = totalVehicles,
        numOfDead = numOfDead,
        fatalAccident = numOfDead > 0,
        numOfInjured = numOfInjured
    )
}