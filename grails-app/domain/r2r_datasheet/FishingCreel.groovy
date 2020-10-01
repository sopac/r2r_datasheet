package r2r_datasheet

import java.sql.Time

class FishingCreel {

    Country country
    String siteId
    String siteName
    String interviewer
    java.sql.Time dateTime
    String latitude
    String longitude

    //
    String village
    String villagerName
    String gender
    String ageRange
    String homeIsland
    int noHouseHold
    String genderFishesInHousehold
    String fishingType //Subsistence, Semi, Commercial
    int subsistenceFishNumberAvg
    int commercialFishNumberAvg
    int semiSubsistenceFishNumberAvg
    String fishingAreaType1 //Outer Reef, Reef Flat, Mangrove
    String fishingAreaType2
    String fishingAreaType3
    String  fishingAreaType4
    String siteLocation1
    String siteLocation2
    String siteLocation3
    String siteLocation4
    boolean oneHabitatPerTrip
    String habitatsOnAverageTrio
    int frequencyOfFishingPerWeek
    String comments

    static constraints = {
        country()
        siteId()
        siteName()
        interviewer()
        dateTime()
        latitude(nullable: true, blank: true)
        longitude(nullable: true, blank: true)
    }
}
