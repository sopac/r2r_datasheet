package r2r_datasheet

import grails.gorm.services.Service

@Service(FishingBenthic)
interface FishingBenthicService {

    FishingBenthic get(Serializable id)

    List<FishingBenthic> list(Map args)

    Long count()

    void delete(Serializable id)

    FishingBenthic save(FishingBenthic fishingBenthic)

}