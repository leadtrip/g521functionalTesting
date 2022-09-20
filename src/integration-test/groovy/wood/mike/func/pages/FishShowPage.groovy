package wood.mike.func.pages

import geb.Page

class FishShowPage extends Page {

    static url = "fish/show"
    static at = {
        title == "Show Fish"
    }

    static content = {
        messageDiv(required: false){ $('.message') }
    }
}
