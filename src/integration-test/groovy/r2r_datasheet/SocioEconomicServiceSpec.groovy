package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SocioEconomicServiceSpec extends Specification {

    SocioEconomicService socioEconomicService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SocioEconomic(...).save(flush: true, failOnError: true)
        //new SocioEconomic(...).save(flush: true, failOnError: true)
        //SocioEconomic socioEconomic = new SocioEconomic(...).save(flush: true, failOnError: true)
        //new SocioEconomic(...).save(flush: true, failOnError: true)
        //new SocioEconomic(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //socioEconomic.id
    }

    void "test get"() {
        setupData()

        expect:
        socioEconomicService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SocioEconomic> socioEconomicList = socioEconomicService.list(max: 2, offset: 2)

        then:
        socioEconomicList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        socioEconomicService.count() == 5
    }

    void "test delete"() {
        Long socioEconomicId = setupData()

        expect:
        socioEconomicService.count() == 5

        when:
        socioEconomicService.delete(socioEconomicId)
        sessionFactory.currentSession.flush()

        then:
        socioEconomicService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SocioEconomic socioEconomic = new SocioEconomic()
        socioEconomicService.save(socioEconomic)

        then:
        socioEconomic.id != null
    }
}
