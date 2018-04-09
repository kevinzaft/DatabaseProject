package databaseproject

class MenuItem {
    Integer item_id
    String name
    String type
    String category
    String description
    Float price
    Float calories
    Integer restaurant_id
    static constraints = {
    }
    static mapping = {
        table "menu_item"
        id generator:'assigned', name:'item_id'
    }
}
