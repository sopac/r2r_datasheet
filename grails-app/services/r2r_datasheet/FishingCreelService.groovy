package r2r_datasheet

import grails.gorm.services.Service

@Service(FishingCreel)
interface FishingCreelService {

    FishingCreel get(Serializable id)

    List<FishingCreel> list(Map args)

    Long count()

    void delete(Serializable id)

    FishingCreel save(FishingCreel fishingCreel)

}