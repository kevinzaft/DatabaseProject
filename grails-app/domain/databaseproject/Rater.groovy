package databaseproject

class Rater {
    Integer rater_id
    String email
    String name
    Date join_date
    String type
    Integer reputation

    static constraints = {

    }
    static mapping = {
        id generator:'increment', name:'rater_id'
    }
}
