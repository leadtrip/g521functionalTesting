package wood.mike.func.pages

import geb.Page

class FishAjaxFormPage extends Page{

    static url = "fish/ajaxFormFish"
    static at = { title == "Fish" }

    static content = {
        theInput{ $('#allFish') }
        theTable(required: false) { $('#fishTable') }
    }
}
