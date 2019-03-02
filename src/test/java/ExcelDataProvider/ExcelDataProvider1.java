package ExcelDataProvider;

	import java.io.File;
	import java.io.FileInputStream;

	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	public class ExcelDataProvider1 
	{
     	XSSFWorkbook wb;
		XSSFSheet sheet;
		XSSFRow row1;
		
		public ExcelDataProvider1()
		{
			
			File src=new File("D:\\selenium\\eclipse-java-photon-R-win32-x86_64\\eclipse\\Workspace\\com.grofers.automation\\TestData\\Flipkart_Login1_valid.xlsx");
			
			try
			{
				FileInputStream fis=new FileInputStream(src);
				
			    wb=new XSSFWorkbook(fis);
				
			} catch (Exception e) 
			{
				//System.out.println("Àxception is "+e.getMessage());
			}
		  	
		}
		
		
		public String getData(int sheetIndex,int row,int column)
		{
			//System.out.println("In getdata Function");
			
			String data;
			try
			{
			
				String data11=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
				data=data11;
			}catch(Exception e)
			{
				
				int numeric_val=(int) wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
				data=String.valueOf(numeric_val);
					
			}	
			
			//System.out.println("value :  " +data);
			
			return data;
		}
		
		public String getData(String sheetName,int row,int column)
		{
			
			String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
				
			return data;
		}
		
		public int getRowCount(int sheetIndex)
		{
			int row=wb.getSheetAt(sheetIndex).getLastRowNum();
			
			row=row+1;
			
			  
		      
			//System.out.println("Total column : "+colNum);
			
			return row;
		}
		
		/*Retrieve the number of column from sheet and row*/
		public int getColumn(int sheetIndex,int row)
		{
			 sheet = wb.getSheetAt(sheetIndex);
			 int colNum = sheet.getRow(row).getLastCellNum();//Retrieve the columns count from row 0 which is column header
			
			//System.out.println("Total column : "+colNum);
			return colNum;
		}
		
		
	}


