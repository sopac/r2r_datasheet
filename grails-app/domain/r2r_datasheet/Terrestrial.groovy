package r2r_datasheet

import java.sql.Time

class Terrestrial {

    Country country
    String siteId
    String siteName
    String surveyor
    java.sql.Time dateTime
    String latitude
    String longitude

    
    String weather
    int elevationM
    String generalHabitatVegetation
    String humanUseLevelOfDisturbance
    String topographicFeatures
    String invasiveSpecies
    String endemicSpecies
    String instroducedSpecies
    String birdsObserved
    String freshwaterFauna
    String nativeTimber
    String siteManagementRecommendations
    String comments


    static constraints = {
        country()
        siteId()
        siteName()
        surveyor()
        dateTime()
        latitude(nullable: true, blank: true)
        longitude(nullable: true, blank: true)
    }
}
