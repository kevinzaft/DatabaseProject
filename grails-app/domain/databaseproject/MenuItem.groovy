package databaseproject

class MenuItem {
    Integer itemID
    String name
    String type
    String category
    String description
    Integer price
    Integer calories
    Integer resturantID
    static constraints = {
    }
    static mapping = {
        table "menu_item"
        id generator:'assigned', name:'itemID'
    }
}
