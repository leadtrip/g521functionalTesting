package wood.mike.func.specs

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import org.openqa.selenium.By
import org.springframework.boot.test.context.SpringBootTest
import wood.mike.func.pages.RandomUiStuffPage

@Integration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RandomUiStuffSpec extends GebSpec{

    void cleanupSpec() {
        browser?.quit()
    }

    void "test click a random checkbox using contains"() {
        when:
            to RandomUiStuffPage
        then:
            $(By.xpath("//*[contains(@id,'inlineCheckbox')]"))[1].click()
    }

    void "test click a random checkbox using starts with"() {
        when:
            to RandomUiStuffPage
        then:
            $(By.xpath("//*[starts-with(@id,'inlineCheckbox')]"))[2].click()
    }
}
