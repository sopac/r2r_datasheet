package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BiologicalServiceSpec extends Specification {

    BiologicalService biologicalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Biological(...).save(flush: true, failOnError: true)
        //new Biological(...).save(flush: true, failOnError: true)
        //Biological biological = new Biological(...).save(flush: true, failOnError: true)
        //new Biological(...).save(flush: true, failOnError: true)
        //new Biological(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //biological.id
    }

    void "test get"() {
        setupData()

        expect:
        biologicalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Biological> biologicalList = biologicalService.list(max: 2, offset: 2)

        then:
        biologicalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        biologicalService.count() == 5
    }

    void "test delete"() {
        Long biologicalId = setupData()

        expect:
        biologicalService.count() == 5

        when:
        biologicalService.delete(biologicalId)
        sessionFactory.currentSession.flush()

        then:
        biologicalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Biological biological = new Biological()
        biologicalService.save(biological)

        then:
        biological.id != null
    }
}
