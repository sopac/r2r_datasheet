package r2r_datasheet

import grails.gorm.services.Service

@Service(Forestry)
interface ForestryService {

    Forestry get(Serializable id)

    List<Forestry> list(Map args)

    Long count()

    void delete(Serializable id)

    Forestry save(Forestry forestry)

}