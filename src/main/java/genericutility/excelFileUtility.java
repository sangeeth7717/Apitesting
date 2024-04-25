package genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.asm.Advice.Return;

/**
 * This is genric method used to read data from excel file and
 * 
 * @author USER
 */
public class excelFileUtility {
	/**
	 * this method read data from excel file and return value to caller
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream File = new FileInputStream(IconstantlyUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(File);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;

	}

	/**
	 * This method will write the data into excel
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream File = new FileInputStream(IconstantlyUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(File);
		wb.createSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(value);
		FileOutputStream Fos = new FileOutputStream(IconstantlyUtility.excelFilePath);
		wb.write(Fos);
		wb.close();
	}
	/**
	 * This method will provide mutiple data to provider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */


	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream File = new FileInputStream(IconstantlyUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(File);
	    Sheet sh = wb.getSheet(sheetName);
	    int lastRow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] data= new Object[lastRow][lastcell];
		for(int i=1;i<lastRow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

	public Object[] readMultipleContactData(String sheetName, int lastcell) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream File = new FileInputStream(IconstantlyUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(File);
	    Sheet sh = wb.getSheet(sheetName);
	    int lastRow = sh.getLastRowNum();
		Object[] data= new Object[lastRow];
		for(int i=2;i<lastRow;i++)
		{
				data[i]=sh.getRow(i).getCell(lastcell).getStringCellValue();
		}
		return data;
	}
}
