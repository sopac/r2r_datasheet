package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FishingCreelServiceSpec extends Specification {

    FishingCreelService fishingCreelService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new FishingCreel(...).save(flush: true, failOnError: true)
        //new FishingCreel(...).save(flush: true, failOnError: true)
        //FishingCreel fishingCreel = new FishingCreel(...).save(flush: true, failOnError: true)
        //new FishingCreel(...).save(flush: true, failOnError: true)
        //new FishingCreel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fishingCreel.id
    }

    void "test get"() {
        setupData()

        expect:
        fishingCreelService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<FishingCreel> fishingCreelList = fishingCreelService.list(max: 2, offset: 2)

        then:
        fishingCreelList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fishingCreelService.count() == 5
    }

    void "test delete"() {
        Long fishingCreelId = setupData()

        expect:
        fishingCreelService.count() == 5

        when:
        fishingCreelService.delete(fishingCreelId)
        sessionFactory.currentSession.flush()

        then:
        fishingCreelService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        FishingCreel fishingCreel = new FishingCreel()
        fishingCreelService.save(fishingCreel)

        then:
        fishingCreel.id != null
    }
}
