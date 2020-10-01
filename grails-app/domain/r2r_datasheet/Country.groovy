package r2r_datasheet

class Country {

    String name
    String projectComponent_1
    String projectComponent_2
    String projectComponent_3
    String projectManager

    static constraints = {
        name()
        projectComponent_1(maxSize: 1250)
        projectComponent_2(maxSize: 1250)
        projectComponent_3(maxSize: 1250)
        projectManager(blank: true, nullable: true)
    }

    String toString(){
        return name
    }
}
