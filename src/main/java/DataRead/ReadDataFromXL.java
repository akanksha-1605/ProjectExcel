package DataRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadDataFromXL {
	
	
	 public static void validate(String fl) throws IOException
	 {
		String location=System.getProperty("user.dir")+fl;
		
		System.out.println(location);
		String strCurrentLine;
		String seg="NM1*0*1*SHARMA*AKS*2";
		BufferedReader objReader = new BufferedReader(new FileReader(location));
        HashMap< String, String> hMap = new HashMap< String,String>();
		   while ((strCurrentLine = objReader.readLine()) != null) {

		    System.out.println(strCurrentLine);
		    if(!strCurrentLine.endsWith("="))
		    {
		    	String args[]=strCurrentLine.split("=");
		    	hMap.put(args[0],args[1]);
		     }
		   }
		   
		   for(String s: hMap.keySet())
		   {
			   System.out.println(s);
			   
			   if(s.equals("LastName")||s.equals("FirstName"))
			   {
				   String h[]=seg.split("[*]");
				   int y=returnnumb(s);
				   if(h[y].equals(hMap.get(s)))
				   {
					   System.out.println(h[y]+" "+"matches with the povided value"+" "+hMap.get(s));
				   }
				   else
				   {
					   System.out.println(h[y]+" "+" not matches with the povided value"+" "+hMap.get(s));

				   }
			   }
			   else if(s.equals("PPO"))
			   {
				   String h[]=seg.split("[*]");
				   int y=returnnumb(s);
				   if(h[y].equals(hMap.get(s)))
				   {
					   System.out.println(h[y]+" "+"matches with the povided value"+" "+hMap.get(s));
				   }
				   else
				   {
					   System.out.println(h[y]+" "+" not matches with the povided value"+" "+hMap.get(s));

				   } 
			   
			   }
		   }
		   
		   
		   
	 }
	 
	 public static int returnnumb(String str)
			 {
		      HashMap<String,Integer> hMap1=new HashMap<String,Integer>();
		      hMap1.put("LastName",3);
		      hMap1.put("FirstName",4);
		      hMap1.put("PPO",5 );
		      return hMap1.get(str);
				
		 
			 }

	    public static void main(String[] args) throws IOException {

	    	{
	    		String fl="\\Resources\\Data.txt";
	    		validate(fl);
	    	}
	    }
}
	
	

