package databaseproject

class Rating {

    Integer userID
    Date date
    Integer price
    Integer food
    Integer mood
    Integer staff
    String comments
    Integer resturantID

    static constraints = {
        price size:1..5
        food size:1..5
        mood size:1..5
        staff size:1..5
    }

    static mapping = {
        price defaultValue:1
        food defaultValue:1
        mood defaultValue:1
        staff defaultValue:1
    }
}
