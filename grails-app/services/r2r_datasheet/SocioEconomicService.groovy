package r2r_datasheet

import grails.gorm.services.Service

@Service(SocioEconomic)
interface SocioEconomicService {

    SocioEconomic get(Serializable id)

    List<SocioEconomic> list(Map args)

    Long count()

    void delete(Serializable id)

    SocioEconomic save(SocioEconomic socioEconomic)

}