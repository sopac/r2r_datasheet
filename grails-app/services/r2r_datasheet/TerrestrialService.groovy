package r2r_datasheet

import grails.gorm.services.Service

@Service(Terrestrial)
interface TerrestrialService {

    Terrestrial get(Serializable id)

    List<Terrestrial> list(Map args)

    Long count()

    void delete(Serializable id)

    Terrestrial save(Terrestrial terrestrial)

}