package r2r_datasheet

import com.xlson.groovycsv.*

@grails.gorm.transactions.Transactional
class InitController {

    String path = "/home/sachin/Dropbox/R2R-SOC-Training/migrate/"

    def index() {
        if (!new File(path).exists()) path = "/home/sachin/migrate/"
        country()
    }


    def country() {
        if (Country.list().size() == 0) {
            String csv = new File(path + "country.csv").getText()
            def data = CsvParser.parseCsv(csv)
            for (l in data) {
                Country c = new Country()
                c.name = l.name
                c.projectManager = l.manager
                c.projectComponent_1 = l.component1
                c.projectComponent_2 = l.component2
                c.projectComponent_3 = l.component3
                c.save(failOnError: true, flush: true)
                println "Saving Country: " + l.name
            }
        }
        render "<h3>Country Imported</h3>"

    }

}



