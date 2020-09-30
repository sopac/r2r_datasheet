package r2r_datasheet

import grails.gorm.services.Service

@Service(WaterChemistry)
interface WaterChemistryService {

    WaterChemistry get(Serializable id)

    List<WaterChemistry> list(Map args)

    Long count()

    void delete(Serializable id)

    WaterChemistry save(WaterChemistry waterChemistry)

}