package wood.mike

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FishController {

    FishService fishService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def ajaxFormFish() {}

    def allFish() {
        render (template: 'fishTable', model: [fish: fishService.findAll()] )
    }

    def fishRedirect() {
        if(params.redirectUrl) {
            redirect url: params.redirectUrl
            return false
        }

        redirect action: 'index'
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fishService.list(params), model:[fishCount: fishService.count()]
    }

    def show(Long id) {
        respond fishService.get(id)
    }

    def create() {
        respond new Fish(params)
    }

    def save(Fish fish) {
        if (fish == null) {
            notFound()
            return
        }

        try {
            fishService.save(fish)
        } catch (ValidationException e) {
            respond fish.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fish.label', default: 'Fish'), fish.id])
                redirect fish
            }
            '*' { respond fish, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fishService.get(id)
    }

    def update(Fish fish) {
        if (fish == null) {
            notFound()
            return
        }

        try {
            fishService.save(fish)
        } catch (ValidationException e) {
            respond fish.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fish.label', default: 'Fish'), fish.id])
                redirect fish
            }
            '*'{ respond fish, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fishService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fish.label', default: 'Fish'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fish.label', default: 'Fish'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
