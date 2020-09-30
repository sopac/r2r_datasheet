package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WaterChemistryServiceSpec extends Specification {

    WaterChemistryService waterChemistryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new WaterChemistry(...).save(flush: true, failOnError: true)
        //new WaterChemistry(...).save(flush: true, failOnError: true)
        //WaterChemistry waterChemistry = new WaterChemistry(...).save(flush: true, failOnError: true)
        //new WaterChemistry(...).save(flush: true, failOnError: true)
        //new WaterChemistry(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //waterChemistry.id
    }

    void "test get"() {
        setupData()

        expect:
        waterChemistryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<WaterChemistry> waterChemistryList = waterChemistryService.list(max: 2, offset: 2)

        then:
        waterChemistryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        waterChemistryService.count() == 5
    }

    void "test delete"() {
        Long waterChemistryId = setupData()

        expect:
        waterChemistryService.count() == 5

        when:
        waterChemistryService.delete(waterChemistryId)
        sessionFactory.currentSession.flush()

        then:
        waterChemistryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        WaterChemistry waterChemistry = new WaterChemistry()
        waterChemistryService.save(waterChemistry)

        then:
        waterChemistry.id != null
    }
}
