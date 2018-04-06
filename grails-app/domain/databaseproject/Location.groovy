package databaseproject

import java.sql.Time

class Location {

    Integer locationID
    Date firstOpenDate
    String managerName
    String phoneNumber
    String streetAddress
    Time openHour
    Time closeHour
    Integer resturantID

    static constraints = {
        closeHour==openHour
    }
}
