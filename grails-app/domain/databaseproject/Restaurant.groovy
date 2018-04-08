package databaseproject

class Restaurant {
    Integer restaurant_id
    String name
    String type
    String url
    static constraints = {

    }
    static mapping = {
        id generator:'assigned', name:'restaurant_id'
    }
}
