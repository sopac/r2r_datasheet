package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WaterQualityController {

    WaterQualityService waterQualityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond waterQualityService.list(params), model:[waterQualityCount: waterQualityService.count()]
    }

    def show(Long id) {
        respond waterQualityService.get(id)
    }

    def create() {
        respond new WaterQuality(params)
    }

    def save(WaterQuality waterQuality) {
        if (waterQuality == null) {
            notFound()
            return
        }

        try {
            waterQualityService.save(waterQuality)
        } catch (ValidationException e) {
            respond waterQuality.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'waterQuality.label', default: 'WaterQuality'), waterQuality.id])
                redirect waterQuality
            }
            '*' { respond waterQuality, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond waterQualityService.get(id)
    }

    def update(WaterQuality waterQuality) {
        if (waterQuality == null) {
            notFound()
            return
        }

        try {
            waterQualityService.save(waterQuality)
        } catch (ValidationException e) {
            respond waterQuality.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'waterQuality.label', default: 'WaterQuality'), waterQuality.id])
                redirect waterQuality
            }
            '*'{ respond waterQuality, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        waterQualityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'waterQuality.label', default: 'WaterQuality'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'waterQuality.label', default: 'WaterQuality'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
