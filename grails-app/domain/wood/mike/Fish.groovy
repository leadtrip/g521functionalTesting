package wood.mike

class Fish {

    String name
    String type

    static belongsTo = [lake: Lake]

    static constraints = {
    }
}
