package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TerrestrialServiceSpec extends Specification {

    TerrestrialService terrestrialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Terrestrial(...).save(flush: true, failOnError: true)
        //new Terrestrial(...).save(flush: true, failOnError: true)
        //Terrestrial terrestrial = new Terrestrial(...).save(flush: true, failOnError: true)
        //new Terrestrial(...).save(flush: true, failOnError: true)
        //new Terrestrial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //terrestrial.id
    }

    void "test get"() {
        setupData()

        expect:
        terrestrialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Terrestrial> terrestrialList = terrestrialService.list(max: 2, offset: 2)

        then:
        terrestrialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        terrestrialService.count() == 5
    }

    void "test delete"() {
        Long terrestrialId = setupData()

        expect:
        terrestrialService.count() == 5

        when:
        terrestrialService.delete(terrestrialId)
        sessionFactory.currentSession.flush()

        then:
        terrestrialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Terrestrial terrestrial = new Terrestrial()
        terrestrialService.save(terrestrial)

        then:
        terrestrial.id != null
    }
}
