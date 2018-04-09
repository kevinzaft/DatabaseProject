package databaseproject

class RatingItem {
    Integer user_id
    Date date
    Integer item_id
    Integer rating
    String comment
    static constraints = {
    }
    static mapping = {
        table "rating_item"
        //id generator:'assigned', name='user_id'
    }

}
