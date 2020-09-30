package r2r_datasheet

import grails.gorm.services.Service

@Service(WaterQuality)
interface WaterQualityService {

    WaterQuality get(Serializable id)

    List<WaterQuality> list(Map args)

    Long count()

    void delete(Serializable id)

    WaterQuality save(WaterQuality waterQuality)

}