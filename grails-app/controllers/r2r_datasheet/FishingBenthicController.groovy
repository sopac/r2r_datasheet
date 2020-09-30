package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FishingBenthicController {

    FishingBenthicService fishingBenthicService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fishingBenthicService.list(params), model:[fishingBenthicCount: fishingBenthicService.count()]
    }

    def show(Long id) {
        respond fishingBenthicService.get(id)
    }

    def create() {
        respond new FishingBenthic(params)
    }

    def save(FishingBenthic fishingBenthic) {
        if (fishingBenthic == null) {
            notFound()
            return
        }

        try {
            fishingBenthicService.save(fishingBenthic)
        } catch (ValidationException e) {
            respond fishingBenthic.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fishingBenthic.label', default: 'FishingBenthic'), fishingBenthic.id])
                redirect fishingBenthic
            }
            '*' { respond fishingBenthic, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fishingBenthicService.get(id)
    }

    def update(FishingBenthic fishingBenthic) {
        if (fishingBenthic == null) {
            notFound()
            return
        }

        try {
            fishingBenthicService.save(fishingBenthic)
        } catch (ValidationException e) {
            respond fishingBenthic.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fishingBenthic.label', default: 'FishingBenthic'), fishingBenthic.id])
                redirect fishingBenthic
            }
            '*'{ respond fishingBenthic, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fishingBenthicService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fishingBenthic.label', default: 'FishingBenthic'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fishingBenthic.label', default: 'FishingBenthic'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
