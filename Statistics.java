 


import java.io.*; 
 import java.io.FileInputStream; 
 import java.io.BufferedReader; 
 import java.io.File; 
 import java.io.IOException; 
 import java.util.Iterator; 
 import java.util.Scanner; 
 import org.apache.poi.ss.usermodel.Sheet; 
 import org.apache.poi.ss.usermodel.Cell; 
 import org.apache.poi.ss.usermodel.Row; 
 import org.apache.poi.ss.usermodel.Workbook; 
 import org.apache.poi.xssf.usermodel.XSSFSheet;  
 import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
 
 
 
 
 public abstract class Statistics  
 { 
 
 
 	private int interception ; 
 	private int fumble ; 
 	private int passing ; 
 	private int receiving ; 
 	private int rushing ; 
 	 
 	public Statistics(int interception, int fumble, int passing, int receiving, int rushing)  
 	{ 
 		this.interception = interception; 
 		this.fumble = fumble; 
 		this.passing = passing; 
 		this.receiving = receiving; 
 		this.rushing = rushing; 
 	} 
 	 
 	public abstract int getInterception();  
 
 
 	public abstract void setInterception(int interception); 
 
 
 	public abstract int getFumble(); 
 
 
 	public abstract void setFumble(int fumble); 
 
 
 	public abstract int getPassing();  

 
 	public abstract void setPassing(int passing);  
 
 
	public abstract int getReceiving(); 
 
 
 	public abstract void setReceiving(int receiving); 
 
 
 	public abstract int getRushing(); 
 	 
 	public abstract void setRushing(int rushing); 
 
 
 	public void readData (String filePath) 
 	{ 
 		try  
 		{ 
 			FileInputStream fi = new FileInputStream(new File(filePath)); 
             XSSFWorkbook wb = new XSSFWorkbook(fi);  
             XSSFSheet sheet = wb.getSheetAt(0); 
             Iterator<Row> rowIt = sheet.iterator(); 
              
             while (rowIt.hasNext())  
             { 
                 Row row = rowIt.next(); 
                 Iterator<Cell> cellIt = row.cellIterator(); 
                   
                 while (cellIt.hasNext())  
                 { 
                     Cell cell = cellIt.next(); 
                     //Check the cell type and format accordingly 
                     switch (cell.getCellType())  
                     { 
                     	case Cell.CELL_TYPE_STRING: 
                         System.out.print(cell.getStringCellValue() + "\t" + "\t"); 
                         break; 
                        case Cell.CELL_TYPE_NUMERIC: 
                             System.out.print(cell.getNumericCellValue() + "\t"); 
                             break; 
                     } 
                 } 
                 System.out.println(" "); 
 			} 
 			fi.close(); 
 		} 
 		catch (IOException e) 
 		{ 
 			e.getMessage(); 
 			e.printStackTrace();; 
 		} 
 	} 
 } 
