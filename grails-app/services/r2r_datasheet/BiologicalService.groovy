package r2r_datasheet

import grails.gorm.services.Service

@Service(Biological)
interface BiologicalService {

    Biological get(Serializable id)

    List<Biological> list(Map args)

    Long count()

    void delete(Serializable id)

    Biological save(Biological biological)

}