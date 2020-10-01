package r2r_datasheet

import java.sql.Time

class Avifauna {

    Country country
    String siteId
    String siteName
    String observer
    java.sql.Time dateTime
    String latitude
    String longitude

    int totalSighted
    //types
    boolean commonMyna
    boolean jungleMyna
    boolean redVentedBulbul
    boolean feralPigeon
    boolean whiteThroatedPigeon
    boolean whiteRumpedSwiftlet
    boolean wattledhoneyeater
    boolean pacificPigeon
    boolean toothBilledPigeon
    boolean scarletRobin
    boolean whistler
    boolean triller
    boolean starling
    boolean flycatcherBroadbill
    boolean fantail
    boolean redHeadedParrotFinch
    boolean purpleCappedFruitDove
    boolean purpleSwamphen
    boolean polynesianTriller
    boolean polynesianStarling
    boolean mao
    boolean manyColouredFruitDove
    boolean longTailedCuckoo
    boolean flatBilledKingfisher
    boolean cardinalMyzomela
    boolean buffBandedRail
    boolean blueCrownedLory
    boolean barnOwl
    boolean whiteBrowedCrake
    boolean spotlessCrake
    boolean shyGroundDove
    boolean australianGreyDuck
    boolean whiteTern
    boolean whiteTailedTropicBird
    boolean blackNoddy
    boolean brownNoddy
    boolean tahitiPetrel
    boolean goldenPlover

    static constraints = {
        country()
        siteId()
        siteName()
        observer()
        dateTime()
        latitude(nullable: true, blank: true)
        longitude(nullable: true, blank: true)
        totalSighted()
    }
}
