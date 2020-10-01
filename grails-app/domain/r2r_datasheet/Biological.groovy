package r2r_datasheet

class Biological {

    Country country
    String siteId
    String siteName
    String observer
    java.sql.Time dateTime
    String latitude
    String longitude


    static constraints = {
        country()
        siteId()
        siteName()
        observer()
        dateTime()
        latitude(nullable: true, blank: true)
        longitude(nullable: true, blank: true)
    }
}
