package r2r_datasheet


import org.apache.commons.lang3.*
import org.grails.datastore.mapping.model.PersistentEntity
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.*
import org.apache.poi.*
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Font
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook


import java.io.File
import  org.apache.poi.xssf.usermodel.*
import  org.apache.poi.xssf.*

class ExportTemplateController {

    def index() {
        //render new Terrestrial().getDomainClass()
        export("avifauna")

    }

    def export(String domainType) {
        def c = null
        if (domainType.equals("terrestrial")) c = new Terrestrial()
        if (domainType.equals("avifauna")) c = new Avifauna()

        def list = []
        list.add("Country")
        list.add("Site Id")
        list.add("Site Name")
        list.add("Date Time")
        list.add("Latitude")
        list.add("Longitude")

        for (p in c.properties) {
            String pn = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(p.key), ' ').capitalize()
            if (!list.contains(pn)) list.add(pn)
        }



        Workbook wb = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
        Sheet sheet = wb.createSheet(domainType.capitalize())
        Row row = sheet.createRow(0);

        Font font = wb.createFont();
        font.setBold(true)
        font.setUnderline(FontUnderline.SINGLE)


        CellStyle style = wb.createCellStyle();
        style.setFont(font);

        int index = 0
        for (p in list){
            Cell cell = row.createCell(index);
            cell.setCellValue(p);
            cell.setCellStyle(style);
            index++
        }

        String path = "/tmp/r2r_" + domainType + "_workbook.xlsx"
        try (OutputStream fileOut = new FileOutputStream(path)) {
            wb.write(fileOut);
        }

        println domainType + " Excel Template Exported"

        render(file: new File(path), fileName: path.replace("/tmp/", "").trim(), contentType: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
    }
}
