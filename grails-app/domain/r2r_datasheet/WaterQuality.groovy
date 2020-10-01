package r2r_datasheet

class WaterQuality {

    Country country
    String siteId
    String siteName
    String observer
    java.sql.Time dateTime
    String latitude
    String longitude

    double temperatureCelcius
    double pH
    double dissolvedOxygenMgl
    double turbidity
    double conductivityUsCcm
    double totalDissolvedSolidsGl
    double salinityMgl
    double phosphorusMgl
    double phosphateMgl
    double nitrateMgl
    double manganeseMgl
    double ammoniaMgl
    double eColiCfu100ml

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
