package databaseproject

class Rater {

    Integer userID
    String email
    String name
    Date join_Date
    String type
    Integer rating

    static constraints = {
        rating size:1..5
        type matches: "(blog)|(online)|(food critic)"

    }

    static mapping = {
        rating defaultValue: 1
    }
}
