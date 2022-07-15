package wood.mike.func.specs

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import org.springframework.boot.test.context.SpringBootTest
import wood.mike.func.pages.FishIndexPage

@Integration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FishFunctionalSpec extends GebSpec{

    void cleanup() {
        browser?.quit()
    }

    void "test ajax tags submitToRemote" () {
        given:
            to FishIndexPage
        when:
            theInput.click()
        then:
            waitFor { theTable.displayed }
    }
}
