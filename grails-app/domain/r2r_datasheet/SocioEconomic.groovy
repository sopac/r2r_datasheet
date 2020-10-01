package r2r_datasheet

class SocioEconomic {


    Country country
    String siteId
    String siteName
    String interviewer
    java.sql.Time dateTime
    String latitude
    String longitude


    String firstName
    String surname
    int age
    String blockNo
    String houseNo
    String village
    String province
    boolean householdHead
    String gender
    String maritalStatus //married, single, divorced, widowed
    String educationLevel //primary, secondary, teteriary, none
    String houseType
    String houseRoofing
    String houseWaterSource
    int noTanks
    String houseFoundation
    int noToilets
    String animalTypes //pigs, horses, cows, dogs, other
    String agricultureCrops //roots, fruits, vegetables, flowes
    String agricultureEnclosement //Fence, Roaming
    String agrictureTypes //Organic, Chemicals, fishFarm
    String energySource// National, Solar, Private
    String agriculturalAssets
    String fisheriesAssets
    String diseaseTypes
    //highBloodPressure, Diabetes, Obesity,	Hypertension, Cardio, Asthma, Lung Disease,	Psychological, Cancer, Other
    String employmentType //private, servant, farming, fishing, livestock, civilService, business, other
    String incomeSource
    String expenses
    String mainSourceOfDiet// Poultry, Meat, TinFish, Price, Income, Taste,	EasyCook, Healthy, Others


    static constraints = {
        country()
        siteId()
        siteName()
        interviewer(nullable: true, blank: true)
        dateTime()
        latitude(nullable: true, blank: true)
        longitude(nullable: true, blank: true)

        //
        firstName()
        surname()
        age()
        blockNo()
        houseNo()
        village()
        province()
        householdHead()
        gender()
        maritalStatus inList: ["married", "single", "divorced", "widowed"]
        educationLevel inList: ["primary", "secondary", "teteriary", "none"]
        houseType()
        houseRoofing()
        houseWaterSource()
        noTanks()
        houseFoundation()
        noToilets()
        animalTypes inList: ["Pigs", "Horses", "Cows", "Dogs", "Other"]
        agricultureCrops inList: ["Roots", "Fruits", "Vegetables", "Flowers", "Others"]
        agricultureEnclosement inList: ["Fence", "Roaming"]
        agrictureTypes inList: ["Organic", "Chemicals", "Fish Farm"]
        energySource inList: [" National", "Solar", "Private"]
        agriculturalAssets()
        fisheriesAssets()
        diseaseTypes inList: ["High Blood Pressure", "Diabetes", "Obesity",	"Hypertension", "Cardio", "Asthma", "Lung Disease,	Psychological", "Cancer", "Other"]
        employmentType inList: ["Private", "Servant", "Farming", "Fishing", "Livestock", "Civil Service", "Business", "Other"]
        incomeSource()
        expenses()
        mainSourceOfDiet inList: ["Poultry", "Meat", "TinFish", "Price", "Income", "Taste,	EasyCook", "Healthy", "Others"]


    }
}
