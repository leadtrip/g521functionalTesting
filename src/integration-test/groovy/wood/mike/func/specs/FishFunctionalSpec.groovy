package wood.mike.func.specs

import geb.spock.GebSpec
import grails.gorm.transactions.ReadOnly
import grails.testing.mixin.integration.Integration
import org.springframework.boot.test.context.SpringBootTest
import wood.mike.Fish
import wood.mike.func.pages.FishAjaxFormPage
import wood.mike.func.pages.FishCreatePage
import wood.mike.func.pages.FishIndexPage
import wood.mike.func.pages.FishRedirectPage
import wood.mike.func.pages.FishShowPage

@Integration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FishFunctionalSpec extends GebSpec{

    void cleanupSpec() {
        browser?.quit()
    }

    void "test ajax tags submitToRemote" () {
        given:
            to FishAjaxFormPage
        when:
            theInput.click()
        then:
            waitFor { theTable.displayed }
    }

    void "test redirect"() {
        given:
            def redirectUrl = 'https://www.bbc.co.uk/'
        when:
            via FishRedirectPage, redirectUrl: redirectUrl
        then:
            waitFor{ currentUrl == redirectUrl }
    }

    void "test index"() {
        when:
            FishIndexPage fishIndexPage = to FishIndexPage
        then:
            fishIndexPage.fishListDiv.displayed
    }

    void "test create fish"() {
        given:
            FishCreatePage fishCreatePage = to FishCreatePage
        when:
            def fishCreateForm = fishCreatePage.form
            fishCreateForm.fillInForm()
            fishCreateForm.submitButton.click()
        then:
            FishShowPage fishShowPage = at FishShowPage
            fishShowPage.messageDiv.text() == "Fish ${latesetFish()} created"
    }

    @ReadOnly
    def latesetFish() {
        Fish.last().id
    }
}
