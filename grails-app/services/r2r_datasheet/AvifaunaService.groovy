package r2r_datasheet

import grails.gorm.services.Service

@Service(Avifauna)
interface AvifaunaService {

    Avifauna get(Serializable id)

    List<Avifauna> list(Map args)

    Long count()

    void delete(Serializable id)

    Avifauna save(Avifauna avifauna)

}