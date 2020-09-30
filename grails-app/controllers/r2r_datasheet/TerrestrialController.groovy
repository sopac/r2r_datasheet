package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TerrestrialController {

    TerrestrialService terrestrialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond terrestrialService.list(params), model:[terrestrialCount: terrestrialService.count()]
    }

    def show(Long id) {
        respond terrestrialService.get(id)
    }

    def create() {
        respond new Terrestrial(params)
    }

    def save(Terrestrial terrestrial) {
        if (terrestrial == null) {
            notFound()
            return
        }

        try {
            terrestrialService.save(terrestrial)
        } catch (ValidationException e) {
            respond terrestrial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'terrestrial.label', default: 'Terrestrial'), terrestrial.id])
                redirect terrestrial
            }
            '*' { respond terrestrial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond terrestrialService.get(id)
    }

    def update(Terrestrial terrestrial) {
        if (terrestrial == null) {
            notFound()
            return
        }

        try {
            terrestrialService.save(terrestrial)
        } catch (ValidationException e) {
            respond terrestrial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'terrestrial.label', default: 'Terrestrial'), terrestrial.id])
                redirect terrestrial
            }
            '*'{ respond terrestrial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        terrestrialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'terrestrial.label', default: 'Terrestrial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'terrestrial.label', default: 'Terrestrial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
