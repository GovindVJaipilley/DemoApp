package Utilities;

import java.io.File;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] getExcelData() {
		Object[][] data = null;
		try {
			//File excelLoc = new File("C:\\Prasad\\Selenium\\POCLiteDemo\\src\\test\\resources\\TestData\\TestData.xlsx");
			File excelLoc = new File("src/test/resources/TestData/TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(excelLoc);
			XSSFSheet sh = wb.getSheetAt(0);
			int rCount = sh.getLastRowNum();
			System.out.println(rCount);
			int cCount = sh.getRow(1).getLastCellNum();
			System.out.println(cCount);
			data = new Object[rCount][cCount];
			for (int i = 1; i <= rCount; i++) {
				for (int j = 0; j < cCount; j++) {
					// data[i-1][j] = sh.getRow(i).getCell(j);
					try {
						if (sh.getRow(i).getCell(j).getCellType() == CellType.STRING) {
							data[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue();
						}
					} catch (NullPointerException e) {
						data[i - 1][j] = "N/A";
					}
				}
			}
			wb.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return data;
	}

}
