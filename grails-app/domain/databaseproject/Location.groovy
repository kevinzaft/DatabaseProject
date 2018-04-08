package databaseproject

import java.sql.Time

class Location {

    Integer locationID
    Date firstOpenDate
    String managerName
    String phoneNumber
    String streetAddress
    String openHour
    String closeHour
    Integer resturantID

    static constraints = {
        //closeHour==openHour
    }
}
