package ExcelSheetReader;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataReaderXl {
    
	public static void main(String args[]) throws IOException
	{
	//To open excel
	String s=System.getProperty("user.dir")+"\\Resources\\DataSheet.xlsx";
	File fl=new File(s);
	
	//To read from file
	FileInputStream input=new FileInputStream(fl);
	XSSFWorkbook wb=new XSSFWorkbook(input);
	Sheet sh=wb.getSheet("Sheet1");
	int i=sh.getLastRowNum()-sh.getFirstRowNum();
	for(int j=0;j<i+1;j++)
	{
		Row ro=sh.getRow(j);
		
		for(int y=0;y<ro.getLastCellNum();y++)
		{
			System.out.println(ro.getCell(y).getStringCellValue());
			System.out.println("Print this message");
		}
	}
	}
}
