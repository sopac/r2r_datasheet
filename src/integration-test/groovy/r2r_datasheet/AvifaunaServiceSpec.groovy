package r2r_datasheet

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AvifaunaServiceSpec extends Specification {

    AvifaunaService avifaunaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Avifauna(...).save(flush: true, failOnError: true)
        //new Avifauna(...).save(flush: true, failOnError: true)
        //Avifauna avifauna = new Avifauna(...).save(flush: true, failOnError: true)
        //new Avifauna(...).save(flush: true, failOnError: true)
        //new Avifauna(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //avifauna.id
    }

    void "test get"() {
        setupData()

        expect:
        avifaunaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Avifauna> avifaunaList = avifaunaService.list(max: 2, offset: 2)

        then:
        avifaunaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        avifaunaService.count() == 5
    }

    void "test delete"() {
        Long avifaunaId = setupData()

        expect:
        avifaunaService.count() == 5

        when:
        avifaunaService.delete(avifaunaId)
        sessionFactory.currentSession.flush()

        then:
        avifaunaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Avifauna avifauna = new Avifauna()
        avifaunaService.save(avifauna)

        then:
        avifauna.id != null
    }
}
