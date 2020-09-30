package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ForestryServiceSpec extends Specification {

    ForestryService forestryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Forestry(...).save(flush: true, failOnError: true)
        //new Forestry(...).save(flush: true, failOnError: true)
        //Forestry forestry = new Forestry(...).save(flush: true, failOnError: true)
        //new Forestry(...).save(flush: true, failOnError: true)
        //new Forestry(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //forestry.id
    }

    void "test get"() {
        setupData()

        expect:
        forestryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Forestry> forestryList = forestryService.list(max: 2, offset: 2)

        then:
        forestryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        forestryService.count() == 5
    }

    void "test delete"() {
        Long forestryId = setupData()

        expect:
        forestryService.count() == 5

        when:
        forestryService.delete(forestryId)
        sessionFactory.currentSession.flush()

        then:
        forestryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Forestry forestry = new Forestry()
        forestryService.save(forestry)

        then:
        forestry.id != null
    }
}
