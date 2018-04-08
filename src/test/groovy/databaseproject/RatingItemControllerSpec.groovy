package databaseproject

import grails.test.mixin.*
import spock.lang.*

@TestFor(RatingItemController)
@Mock(RatingItem)
class RatingItemControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.ratingItemList
            model.ratingItemCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.ratingItem!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def ratingItem = new RatingItem()
            ratingItem.validate()
            controller.save(ratingItem)

        then:"The create view is rendered again with the correct model"
            model.ratingItem!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            ratingItem = new RatingItem(params)

            controller.save(ratingItem)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/ratingItem/show/1'
            controller.flash.message != null
            RatingItem.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def ratingItem = new RatingItem(params)
            controller.show(ratingItem)

        then:"A model is populated containing the domain instance"
            model.ratingItem == ratingItem
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def ratingItem = new RatingItem(params)
            controller.edit(ratingItem)

        then:"A model is populated containing the domain instance"
            model.ratingItem == ratingItem
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/ratingItem/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def ratingItem = new RatingItem()
            ratingItem.validate()
            controller.update(ratingItem)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.ratingItem == ratingItem

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            ratingItem = new RatingItem(params).save(flush: true)
            controller.update(ratingItem)

        then:"A redirect is issued to the show action"
            ratingItem != null
            response.redirectedUrl == "/ratingItem/show/$ratingItem.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/ratingItem/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def ratingItem = new RatingItem(params).save(flush: true)

        then:"It exists"
            RatingItem.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(ratingItem)

        then:"The instance is deleted"
            RatingItem.count() == 0
            response.redirectedUrl == '/ratingItem/index'
            flash.message != null
    }
}
