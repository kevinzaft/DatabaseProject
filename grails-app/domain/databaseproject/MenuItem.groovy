package databaseproject

class MenuItem {

    Integer itemID
    String name
    String type
    String category
    String description
    Float price
    Float calories
    Integer resturantID

    static constraints = {
        type matches: "(food)|(beverage)"
    }
}
