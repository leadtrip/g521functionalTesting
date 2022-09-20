package wood.mike

class Lake {

    String name
    String location

    static hasMany = [fish: Fish]

    static constraints = {
    }
}
