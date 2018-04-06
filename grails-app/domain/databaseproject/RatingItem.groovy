package databaseproject

import java.sql.Date

class RatingItem {

    Integer userID
    Date date
    Integer itemID
    Integer rating
    String comment

    static constraints = {
        rating size:1..5
    }

    static mapping = {
        rating defaultValue:1
    }
}
