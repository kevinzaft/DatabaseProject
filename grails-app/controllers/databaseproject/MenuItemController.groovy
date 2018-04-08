package databaseproject

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MenuItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MenuItem.list(params), model:[menuItemCount: MenuItem.count()]
    }

    def show(MenuItem menuItem) {
        respond menuItem
    }

    def create() {
        respond new MenuItem(params)
    }

    @Transactional
    def save(MenuItem menuItem) {
        if (menuItem == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (menuItem.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond menuItem.errors, view:'create'
            return
        }

        menuItem.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'menuItem.label', default: 'MenuItem'), menuItem.id])
                redirect menuItem
            }
            '*' { respond menuItem, [status: CREATED] }
        }
    }

    def edit(MenuItem menuItem) {
        respond menuItem
    }

    @Transactional
    def update(MenuItem menuItem) {
        if (menuItem == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (menuItem.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond menuItem.errors, view:'edit'
            return
        }

        menuItem.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'menuItem.label', default: 'MenuItem'), menuItem.id])
                redirect menuItem
            }
            '*'{ respond menuItem, [status: OK] }
        }
    }

    @Transactional
    def delete(MenuItem menuItem) {

        if (menuItem == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        menuItem.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'menuItem.label', default: 'MenuItem'), menuItem.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'menuItem.label', default: 'MenuItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
