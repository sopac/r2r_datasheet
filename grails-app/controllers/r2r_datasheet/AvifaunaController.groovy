package r2r_datasheet

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AvifaunaController {

    AvifaunaService avifaunaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond avifaunaService.list(params), model:[avifaunaCount: avifaunaService.count()]
    }

    def show(Long id) {
        respond avifaunaService.get(id)
    }

    def create() {
        respond new Avifauna(params)
    }

    def save(Avifauna avifauna) {
        if (avifauna == null) {
            notFound()
            return
        }

        try {
            avifaunaService.save(avifauna)
        } catch (ValidationException e) {
            respond avifauna.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'avifauna.label', default: 'Avifauna'), avifauna.id])
                redirect avifauna
            }
            '*' { respond avifauna, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond avifaunaService.get(id)
    }

    def update(Avifauna avifauna) {
        if (avifauna == null) {
            notFound()
            return
        }

        try {
            avifaunaService.save(avifauna)
        } catch (ValidationException e) {
            respond avifauna.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'avifauna.label', default: 'Avifauna'), avifauna.id])
                redirect avifauna
            }
            '*'{ respond avifauna, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        avifaunaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'avifauna.label', default: 'Avifauna'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'avifauna.label', default: 'Avifauna'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
