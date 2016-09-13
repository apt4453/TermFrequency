import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class MakeOccurCount {

	public ArrayList<String> pool;
	public HashMap<String, String> Nvalue;
	
	public MakeOccurCount() {
		// TODO Auto-generated constructor stub
		
		String cvsdata = new String(Config.result_report);
		
		CSVReader reader;
		
		
		String[] dataline;
		
		ArrayList<String> resultSet = new ArrayList<String>();
		
			 
		try {
			reader = new CSVReader(new FileReader(cvsdata));
		
			while ((dataline = reader.readNext()) != null) {
					 
					if(dataline.length == 6){
					
					System.out.println(dataline);
					 
					String _id = dataline[0].trim();
					String _time = dataline[1].trim();
					String _unknown = dataline[2].trim();
					String _event = dataline[3].trim();
					String _result = dataline[4].trim();
					String _count = dataline[5].trim();
					 
					resultSet.add(_result);

					}
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.pool = resultSet;
		
		Nvalue = new HashMap<String,String>();
		
		calculateN();
	
			
	}
	
	
	
	

	private void calculateN() {
		// TODO Auto-generated method stub
		int event_num = Config.event_num;
		
		
		for(int i=0 ; i< event_num ; i++){
			
			int count = 0;
			
			String ec = new String("e"+Integer.toString(i+1)+"=");
			
			ArrayList<String> clone = pool;
			
			for(int j = 0 ; j<clone.size() ;j++){
				
				String el = clone.get(j);
				
				
				if(el.contains(ec)){
					
					count++;
					
					
				}
			}
			
			System.out.println("e"+Integer.toString(i+1) + "   , "+count);
			
			Nvalue.put("e"+Integer.toString(i+1), Integer.toString(count));
		}//end of for
		
		
	}


	public String getN(String e){
		
		return Nvalue.get(e);
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new MakeOccurCount();
		
		
	}

}
