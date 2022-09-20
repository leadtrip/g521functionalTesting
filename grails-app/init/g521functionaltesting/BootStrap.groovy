package g521functionaltesting

import grails.gorm.transactions.Transactional
import wood.mike.Fish
import wood.mike.Lake

class BootStrap {

    def init = { servletContext ->
        addFish()
    }

    @Transactional
    def addFish() {
        def shearWater = new Lake( name: 'Shearwater', location: 'Westbury' )

        shearWater.addToFish( new Fish(type: 'Carp', name: 'Clive' ) )
        shearWater.addToFish( new Fish(type: 'Pike', name: 'Peter') )
        shearWater.addToFish( new Fish(type: 'Eel', name: 'Eric') )
        shearWater.addToFish( new Fish(type: 'Roach', name: 'Ryan') )
        shearWater.addToFish( new Fish(type: 'Bream', name: 'Barry') )
        shearWater.addToFish( new Fish(type: 'Tench', name: 'Terry') )

        shearWater.save()
    }

    def destroy = {
    }
}
