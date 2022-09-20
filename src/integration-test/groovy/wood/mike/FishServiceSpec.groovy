package wood.mike

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FishServiceSpec extends Specification {

    FishService fishService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fish(...).save(flush: true, failOnError: true)
        //new Fish(...).save(flush: true, failOnError: true)
        //Fish fish = new Fish(...).save(flush: true, failOnError: true)
        //new Fish(...).save(flush: true, failOnError: true)
        //new Fish(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fish.id
    }

    void "test get"() {
        setupData()

        expect:
        fishService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fish> fishList = fishService.list(max: 2, offset: 2)

        then:
        fishList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fishService.count() == 5
    }

    void "test delete"() {
        Long fishId = setupData()

        expect:
        fishService.count() == 5

        when:
        fishService.delete(fishId)
        sessionFactory.currentSession.flush()

        then:
        fishService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fish fish = new Fish()
        fishService.save(fish)

        then:
        fish.id != null
    }
}
