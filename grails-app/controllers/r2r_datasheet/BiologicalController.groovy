package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BiologicalController {

    BiologicalService biologicalService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond biologicalService.list(params), model:[biologicalCount: biologicalService.count()]
    }

    def show(Long id) {
        respond biologicalService.get(id)
    }

    def create() {
        respond new Biological(params)
    }

    def save(Biological biological) {
        if (biological == null) {
            notFound()
            return
        }

        try {
            biologicalService.save(biological)
        } catch (ValidationException e) {
            respond biological.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'biological.label', default: 'Biological'), biological.id])
                redirect biological
            }
            '*' { respond biological, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond biologicalService.get(id)
    }

    def update(Biological biological) {
        if (biological == null) {
            notFound()
            return
        }

        try {
            biologicalService.save(biological)
        } catch (ValidationException e) {
            respond biological.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'biological.label', default: 'Biological'), biological.id])
                redirect biological
            }
            '*'{ respond biological, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        biologicalService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'biological.label', default: 'Biological'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'biological.label', default: 'Biological'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
