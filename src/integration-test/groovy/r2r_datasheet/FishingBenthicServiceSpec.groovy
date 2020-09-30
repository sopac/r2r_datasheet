package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FishingBenthicServiceSpec extends Specification {

    FishingBenthicService fishingBenthicService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new FishingBenthic(...).save(flush: true, failOnError: true)
        //new FishingBenthic(...).save(flush: true, failOnError: true)
        //FishingBenthic fishingBenthic = new FishingBenthic(...).save(flush: true, failOnError: true)
        //new FishingBenthic(...).save(flush: true, failOnError: true)
        //new FishingBenthic(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fishingBenthic.id
    }

    void "test get"() {
        setupData()

        expect:
        fishingBenthicService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<FishingBenthic> fishingBenthicList = fishingBenthicService.list(max: 2, offset: 2)

        then:
        fishingBenthicList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fishingBenthicService.count() == 5
    }

    void "test delete"() {
        Long fishingBenthicId = setupData()

        expect:
        fishingBenthicService.count() == 5

        when:
        fishingBenthicService.delete(fishingBenthicId)
        sessionFactory.currentSession.flush()

        then:
        fishingBenthicService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        FishingBenthic fishingBenthic = new FishingBenthic()
        fishingBenthicService.save(fishingBenthic)

        then:
        fishingBenthic.id != null
    }
}
