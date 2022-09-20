package wood.mike.func.pages

import geb.Page
import wood.mike.func.modules.FishFormModule

class FishCreatePage extends Page {

    static url = "fish/create"
    static at = {
        title == "Create Fish"
    }

    static content = {
        form(required: true){ module FishFormModule }
    }
}
