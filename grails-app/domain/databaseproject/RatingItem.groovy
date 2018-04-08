package databaseproject

class RatingItem {
    Integer userID
    Date date
    Integer itemID
    Integer rating
    String comment
    static constraints = {
    }
    static mapping = {
        table "rating_item"
    }

}
