package g521functionaltesting

import grails.gorm.transactions.Transactional
import wood.mike.Fish

class BootStrap {

    def init = { servletContext ->
        addFish()
    }

    @Transactional
    def addFish() {
        new Fish(name: 'Carp').save()
        new Fish(name: 'Pike').save()
        new Fish(name: 'Eel').save()
        new Fish(name: 'Roach').save()
        new Fish(name: 'Bream').save()
        new Fish(name: 'Tench').save()
    }

    def destroy = {
    }
}
