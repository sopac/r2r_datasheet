package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WaterChemistryController {

    WaterChemistryService waterChemistryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond waterChemistryService.list(params), model:[waterChemistryCount: waterChemistryService.count()]
    }

    def show(Long id) {
        respond waterChemistryService.get(id)
    }

    def create() {
        respond new WaterChemistry(params)
    }

    def save(WaterChemistry waterChemistry) {
        if (waterChemistry == null) {
            notFound()
            return
        }

        try {
            waterChemistryService.save(waterChemistry)
        } catch (ValidationException e) {
            respond waterChemistry.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'waterChemistry.label', default: 'WaterChemistry'), waterChemistry.id])
                redirect waterChemistry
            }
            '*' { respond waterChemistry, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond waterChemistryService.get(id)
    }

    def update(WaterChemistry waterChemistry) {
        if (waterChemistry == null) {
            notFound()
            return
        }

        try {
            waterChemistryService.save(waterChemistry)
        } catch (ValidationException e) {
            respond waterChemistry.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'waterChemistry.label', default: 'WaterChemistry'), waterChemistry.id])
                redirect waterChemistry
            }
            '*'{ respond waterChemistry, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        waterChemistryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'waterChemistry.label', default: 'WaterChemistry'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'waterChemistry.label', default: 'WaterChemistry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
