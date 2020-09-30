package r2r_datasheet

import com.xlson.groovycsv.*

class InitController {

    String path = "/home/sachin/Dropbox/R2R-SOC-Training/migrate/"

    def index() {
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
                c.save(failOnError: true)
            }
        }
        render "<h3>Country Imported</h3>"

    }

}



