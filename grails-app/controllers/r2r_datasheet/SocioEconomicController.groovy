package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SocioEconomicController {

    SocioEconomicService socioEconomicService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond socioEconomicService.list(params), model:[socioEconomicCount: socioEconomicService.count()]
    }

    def show(Long id) {
        respond socioEconomicService.get(id)
    }

    def create() {
        respond new SocioEconomic(params)
    }

    def save(SocioEconomic socioEconomic) {
        if (socioEconomic == null) {
            notFound()
            return
        }

        try {
            socioEconomicService.save(socioEconomic)
        } catch (ValidationException e) {
            respond socioEconomic.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'socioEconomic.label', default: 'SocioEconomic'), socioEconomic.id])
                redirect socioEconomic
            }
            '*' { respond socioEconomic, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond socioEconomicService.get(id)
    }

    def update(SocioEconomic socioEconomic) {
        if (socioEconomic == null) {
            notFound()
            return
        }

        try {
            socioEconomicService.save(socioEconomic)
        } catch (ValidationException e) {
            respond socioEconomic.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'socioEconomic.label', default: 'SocioEconomic'), socioEconomic.id])
                redirect socioEconomic
            }
            '*'{ respond socioEconomic, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        socioEconomicService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'socioEconomic.label', default: 'SocioEconomic'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'socioEconomic.label', default: 'SocioEconomic'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
