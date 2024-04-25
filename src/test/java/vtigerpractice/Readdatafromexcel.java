package vtigerpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//Step1 : Open file in java readable format
		FileInputStream File= new FileInputStream(".//src//test//resources//Testdata.xlsx");
//step2 : create workbook factory		
		Workbook wb= WorkbookFactory.create(File);
//step3 : get control of sheet		
		Sheet sh1 = wb.getSheet("Organization");
//step4 : get control of row		
		Row rw1 = sh1.getRow(1);
//step5 : get control of cell		
         Cell ce1 = rw1.getCell(2);
         System.out.println(ce1);
		
	}

}
