package com.page;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datadriven {

     static WebDriver driver;

    public static void datadriv() throws IOException {
	     // TODO Auto-generated method stub
    	
    	System.setProperty("webdriver.chrome.driver", "D:\\New folder\\Study\\Selenium\\src\\Driver\\chromedriver.exe");
    	driver = new ChromeDriver();
    	
    	ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        File f = new File("D:\\New folder\\Study\\Data.xlsx");
        FileInputStream fin = new FileInputStream(f);
        Workbook w = new XSSFWorkbook(fin);
    	Sheet s = w.getSheet("Sheet1");
    	Row header = s.getRow(0);
    	
    	for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
    		HashMap<String, String>mapdata = new HashMap<String, String>();
    		Row row = s.getRow(i);
    		
    		for(int j=0;j<row.getPhysicalNumberOfCells();j++)
    		{
    			Cell cell = row.getCell(j);
    			CellType cetype = cell.getCellType();
    		    if(cetype == cetype.STRING) {
    		    	String string = cell.getStringCellValue();
    		    	mapdata.put(header.getCell(j).getStringCellValue(), string);
    		    	
    		    }else if(cetype == cetype.NUMERIC) {
    		    	double numeric = cell.getNumericCellValue();
    		    	long l =  (long) numeric;
    		    	String value = String.valueOf(l);
    		    	mapdata.put(header.getCell(j).getStringCellValue(),value);
    		    }
    		
    		}
    		list.add(mapdata);
    		}
    	
    	FileOutputStream fout = new FileOutputStream(f);
    	w.write(fout);
    	fout.close();
    	
    	System.out.println(list.get(1).get("username"));
    	System.out.println(list.get(2).get("password"));
    	
    	driver.findElement(By.id("email")).sendKeys("username");
    	driver.findElement(By.name("pass")).sendKeys("password");

}


}
