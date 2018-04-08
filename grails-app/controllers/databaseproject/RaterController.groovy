package databaseproject

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RaterController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Rater.list(params), model:[raterCount: Rater.count()]
    }

    def show(Rater rater) {
        respond rater
    }

    def create() {
        respond new Rater(params)
    }

    @Transactional
    def save(Rater rater) {
        if (rater == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rater.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rater.errors, view:'create'
            return
        }

        rater.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rater.label', default: 'Rater'), rater.id])
                redirect rater
            }
            '*' { respond rater, [status: CREATED] }
        }
    }

    def edit(Rater rater) {
        respond rater
    }

    @Transactional
    def update(Rater rater) {
        if (rater == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rater.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rater.errors, view:'edit'
            return
        }

        rater.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rater.label', default: 'Rater'), rater.id])
                redirect rater
            }
            '*'{ respond rater, [status: OK] }
        }
    }

    @Transactional
    def delete(Rater rater) {

        if (rater == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        rater.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rater.label', default: 'Rater'), rater.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rater.label', default: 'Rater'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
