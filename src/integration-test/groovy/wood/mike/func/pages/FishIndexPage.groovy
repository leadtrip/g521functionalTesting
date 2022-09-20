package wood.mike.func.pages

import geb.Page

class FishIndexPage extends Page{

    static url = "fish/index"
    static at = {
        title == "Fish List"
        layout == 'main'
        pageId == 'fish.index'
    }

    static content = {
        pageId { $('meta', name: 'pageId').first().@content }   // added in layout main.gsp in test environment
        layout { $('meta', name: 'layout').first().@content }
        fishListDiv(required: false) { $('#list-fish')  }
    }
}
