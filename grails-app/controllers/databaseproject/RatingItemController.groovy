package databaseproject

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RatingItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RatingItem.list(params), model:[ratingItemCount: RatingItem.count()]
    }

    def show(RatingItem ratingItem) {
        respond ratingItem
    }

    def create() {
        respond new RatingItem(params)
    }

    @Transactional
    def save(RatingItem ratingItem) {
        if (ratingItem == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (ratingItem.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond ratingItem.errors, view:'create'
            return
        }

        ratingItem.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ratingItem.label', default: 'RatingItem'), ratingItem.id])
                redirect ratingItem
            }
            '*' { respond ratingItem, [status: CREATED] }
        }
    }

    def edit(RatingItem ratingItem) {
        respond ratingItem
    }

    @Transactional
    def update(RatingItem ratingItem) {
        if (ratingItem == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (ratingItem.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond ratingItem.errors, view:'edit'
            return
        }

        ratingItem.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ratingItem.label', default: 'RatingItem'), ratingItem.id])
                redirect ratingItem
            }
            '*'{ respond ratingItem, [status: OK] }
        }
    }

    @Transactional
    def delete(RatingItem ratingItem) {

        if (ratingItem == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        ratingItem.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ratingItem.label', default: 'RatingItem'), ratingItem.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ratingItem.label', default: 'RatingItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
