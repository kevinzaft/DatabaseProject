package databaseproject

class Rater {
    Integer rater_id
    String email
    String name
    Date join_date
    String type
    String reputation

    static constraints = {
    }
    static mapping = {
        id generator:'assigned', name:'rater_id'
    }
}
