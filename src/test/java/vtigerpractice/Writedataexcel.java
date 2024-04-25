package vtigerpractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writedataexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Step1 : Open file in java readable format	
		FileInputStream File= new FileInputStream(".//src//test//resources//Testdata.xlsx");
		//step2 : create workbook factory
		Workbook wb= WorkbookFactory.create(File);
		//step3 : get control of sheet
		Sheet sh1 = wb.getSheet("Organization");
		//step4 : create of row			
		Row rw1 = sh1.createRow(1);
		//step5 : create of cell
		Cell ce1 = rw1.createCell(3);
		// sending values to the cell
		ce1.setCellValue("sangeeth");
		//Step6 : Open file in java writable format	
		FileOutputStream fos= new FileOutputStream(".//src//test//resources//Testdata.xlsx");
		//step7 : writing in the cell
		wb.write(fos);
		System.out.println("data written");
	}

}
