package databaseproject

class Location {
    Integer location_id
    Date first_open_date
    String manager_name
    String phone_number
    String hour_open
    String hour_close
    Integer restaurant_id
    static constraints = {
    }
    static mapping = {
        id generator:'assigned', name:'location_id'
    }
}
