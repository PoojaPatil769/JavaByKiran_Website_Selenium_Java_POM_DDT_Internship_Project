package utils;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil {

    public static Object[][] getData(String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(
                "C:\\WorkSpace\\Pooja_Workspace\\selenium\\Eclipse workspace\\javaByKiran_project_POM_DDT\\Excel\\ExcelD.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // 🔥 IMPORTANT SAFETY CHECK
        if (sheet == null) {
            workbook.close();
            fis.close();
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];
        DataFormatter df = new DataFormatter();

        for (int i = 1; i <= rows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = df.formatCellValue(row.getCell(j));
         }
        }

        workbook.close();
        fis.close();
        return data;
    }
}
