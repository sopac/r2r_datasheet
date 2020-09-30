package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ForestryController {

    ForestryService forestryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond forestryService.list(params), model:[forestryCount: forestryService.count()]
    }

    def show(Long id) {
        respond forestryService.get(id)
    }

    def create() {
        respond new Forestry(params)
    }

    def save(Forestry forestry) {
        if (forestry == null) {
            notFound()
            return
        }

        try {
            forestryService.save(forestry)
        } catch (ValidationException e) {
            respond forestry.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'forestry.label', default: 'Forestry'), forestry.id])
                redirect forestry
            }
            '*' { respond forestry, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond forestryService.get(id)
    }

    def update(Forestry forestry) {
        if (forestry == null) {
            notFound()
            return
        }

        try {
            forestryService.save(forestry)
        } catch (ValidationException e) {
            respond forestry.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'forestry.label', default: 'Forestry'), forestry.id])
                redirect forestry
            }
            '*'{ respond forestry, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        forestryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'forestry.label', default: 'Forestry'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'forestry.label', default: 'Forestry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
