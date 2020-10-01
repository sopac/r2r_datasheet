package r2r_datasheet

import java.sql.Time

class FishingBenthic {

    Country country
    String siteId
    String siteName
    java.sql.Time dateTime
    String latitude
    String longitude
    String habitatType

    //
    int transect
    double crustoseCorallineAlgae
    double macroAlage
    double turfAlgaeCover
    double totalBiomass
    double coralCover
    double depthAverage
    double topographySlopeDegree
    double slope
    double curvature
    double planarCurvatureStandardDeviation
    double profileCurvatureMmean
    double surfaceAspectDegree
    double totalSuspendedSediments
    double herbivoreBiomass
    double targetFishes
    double fishingIndex04


    static constraints = {
        country()
        siteId()
        siteName()
        dateTime()
        latitude(nullable: true, blank: true)
        longitude(nullable: true, blank: true)
    }
}
