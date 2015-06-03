package NET.webserviceX.www;

import java.util.Map;
import java.util.Map.Entry;
import java.rmi.RemoteException;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.rpc.ServiceException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

import java.io.*;



public class test extends StdStats {
	//private static double hrs = 0.5;
	private static String str;
	private static double StockVal;
	private static String[] data = new String[30]; 
	private static Document doc;
	private static DocumentBuilder db;
	private static double[] StdDevData = new double[30];    
	/*private static int count = (int) (hrs * 60 * 0.2);   //for period= 5 min, for 10 min change it to 0.1
	//private static int count = 4;
	private static Double[] Stockdata= new Double[count];*/
	private static HashMap<String,List<Double>> dataMap = new HashMap<String,List<Double>>();
	
	
	public static void main(String[] args) throws IOException {
				System.out.println("Enter the time in hours, for which you want to run this program; Select between 0.5-24" );
				Scanner in = new Scanner(System.in);
			    double hrs = in.nextDouble(); 
				System.out.println("hours=" +hrs);
				 int count = (int) (hrs * 60 * 0.1);   //for period= 5 min, for 10 min change it to 0.1
				//private static int count = 4;
			 Double[] Stockdata= new Double[count];
		
			 
			 // input from text file
		String currentline; 
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("Idata.txt"));
			} 
		catch (FileNotFoundException e1){
			e1.printStackTrace();
			}

		try{
			int i=0;
			while ((currentline = br.readLine()) != null){
			  System.out.println(currentline);
			  data[i] = currentline;
			  i++;
			}
			} 
		catch (IOException e1){
			e1.printStackTrace();
			}
		
		
		//Apply loop for every 10 min execution
		int t=0;
		while (t<count){
		for(int k=0; k<30; k++)
		{
			try {
				str = new StockQuoteLocator().getStockQuoteSoap().getQuote(data[k]);
			} catch (RemoteException e) {

				e.printStackTrace();
			} catch (ServiceException e) {
				
				e.printStackTrace();
			}
			
			// Write in an output file
			try{
				    String filename = "output.txt";
				    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				    fw.write(str + "\r\n"); //appends the string to the file
				    fw.close();
				
				}
			catch (FileNotFoundException e) {
				e.printStackTrace();
				}
			catch (IOException e) {
				e.printStackTrace();
				}
			
			// XML parser
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				try {
					db = dbf.newDocumentBuilder();
				} catch (ParserConfigurationException e) {
					System.out.println("Error in dbf");
					e.printStackTrace();
				}
		        
				InputSource is = new InputSource();
		        str = str.replaceAll("&", "&amp;");
		        is.setCharacterStream(new StringReader(str));
		    
				try {
					doc = db.parse(is);
				} catch (SAXException e) {
					System.out.println("Error in SAXExcep");
				e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error in IOExcep");
					e.printStackTrace();
				}
		        
		        NodeList Last = doc.getElementsByTagName("Last");
		           Element line = (Element) Last.item(0);
		        
			StockVal = Double.parseDouble(getCharacterDataFromElement(line));
			if (dataMap.get(data[k]) == null){ 
				List<Double> Ruchi = new ArrayList<Double>();
				dataMap.put(data[k], Ruchi);
				}
				dataMap.get(data[k]).add(StockVal);	
				
		 }
		
		try {
		    Thread.sleep(600000);    // Specify the time periodic time
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		t+=1;
		}

		
		// Writes the <symbol, stock value> in a text file 
	
			for (Map.Entry<String, List<Double>> entry : dataMap.entrySet()){
			 System.out.println( entry.getKey());     
		     System.out.println( entry.getValue());//Returns the list of values
			
		     String abc = (String)(entry.getKey() + entry.getValue()) ;
		
		     try{
		    	 String filename1 = "92847835.txt";
		    	 FileWriter fw = new FileWriter(filename1,true); //the true will append the new data
		    	 fw.write(abc + "\r\n"); //appends the string to the file
		    	 fw.close();
		     	}
		     	catch (FileNotFoundException e) {
		     		e.printStackTrace();
		     	}
		     	catch (IOException e) {
		     		e.printStackTrace();
		     	}
			}
		
		
	
		for(int j=0; j<30; j++){
		Stockdata = (dataMap.get(data[j]).toArray(Stockdata));
			
		StdDevData[j] = stddev(Stockdata);
		}
			
		double maximum = max(StdDevData);
		System.out.println("Maximum value"+ " " + maximum);
		int k=0;
		while(StdDevData[k]!= maximum){
			k++;
		}
		System.out.println("Company with maximum fluctutation"+ "-" + data[k]);
		
}

	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	       CharacterData cd = (CharacterData) child;
	       return (cd.getData());
	    }
	    return "?";
	  }

}