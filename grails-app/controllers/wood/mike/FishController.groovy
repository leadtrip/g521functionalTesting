package wood.mike

class FishController {

    def fishService

    def index() { }

    def allFish() {
        render (template: 'fishTable', model: [fish: fishService.findAll()] )
    }
}
