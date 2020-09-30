package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WaterQualityServiceSpec extends Specification {

    WaterQualityService waterQualityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new WaterQuality(...).save(flush: true, failOnError: true)
        //new WaterQuality(...).save(flush: true, failOnError: true)
        //WaterQuality waterQuality = new WaterQuality(...).save(flush: true, failOnError: true)
        //new WaterQuality(...).save(flush: true, failOnError: true)
        //new WaterQuality(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //waterQuality.id
    }

    void "test get"() {
        setupData()

        expect:
        waterQualityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<WaterQuality> waterQualityList = waterQualityService.list(max: 2, offset: 2)

        then:
        waterQualityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        waterQualityService.count() == 5
    }

    void "test delete"() {
        Long waterQualityId = setupData()

        expect:
        waterQualityService.count() == 5

        when:
        waterQualityService.delete(waterQualityId)
        sessionFactory.currentSession.flush()

        then:
        waterQualityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        WaterQuality waterQuality = new WaterQuality()
        waterQualityService.save(waterQuality)

        then:
        waterQuality.id != null
    }
}
