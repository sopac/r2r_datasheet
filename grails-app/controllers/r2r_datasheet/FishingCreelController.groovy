package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FishingCreelController {

    FishingCreelService fishingCreelService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fishingCreelService.list(params), model:[fishingCreelCount: fishingCreelService.count()]
    }

    def show(Long id) {
        respond fishingCreelService.get(id)
    }

    def create() {
        respond new FishingCreel(params)
    }

    def save(FishingCreel fishingCreel) {
        if (fishingCreel == null) {
            notFound()
            return
        }

        try {
            fishingCreelService.save(fishingCreel)
        } catch (ValidationException e) {
            respond fishingCreel.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fishingCreel.label', default: 'FishingCreel'), fishingCreel.id])
                redirect fishingCreel
            }
            '*' { respond fishingCreel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fishingCreelService.get(id)
    }

    def update(FishingCreel fishingCreel) {
        if (fishingCreel == null) {
            notFound()
            return
        }

        try {
            fishingCreelService.save(fishingCreel)
        } catch (ValidationException e) {
            respond fishingCreel.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fishingCreel.label', default: 'FishingCreel'), fishingCreel.id])
                redirect fishingCreel
            }
            '*'{ respond fishingCreel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fishingCreelService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fishingCreel.label', default: 'FishingCreel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fishingCreel.label', default: 'FishingCreel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
