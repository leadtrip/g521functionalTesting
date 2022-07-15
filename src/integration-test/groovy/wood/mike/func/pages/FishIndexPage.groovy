package wood.mike.func.pages

import geb.Page

class FishIndexPage extends Page{

    static url = "fish/index"
    static at = { title == "Fish" }

    static content = {
        theInput{ $('#allFish') }
        theTable(required: false) { $('#fishTable') }
    }
}
