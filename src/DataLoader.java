import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import au.com.bytecode.opencsv.CSVReader;




public class DataLoader {

	public DataLoader() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		MakeOccurCount getn = new MakeOccurCount();
				
		
		String cvsdata = new String(Config.result_report);
		
		CSVReader reader;
		
		
		String[] dataline;
		
		BufferedWriter result_file_writer = new BufferedWriter(new FileWriter(Config.tf_out_file));
		
		
			 
		try {
			reader = new CSVReader(new FileReader(cvsdata));
		
			while ((dataline = reader.readNext()) != null) {
					 
					 //System.out.println(dataline);
					 
					String _id = dataline[0].trim();
					String _time = dataline[1].trim();
					String _unknown = dataline[2].trim();
					String _event = dataline[3].trim();
					String _result = dataline[4].trim();
					String _count = dataline[5].trim();
					 
					evidence e1 = new evidence(_id, _time, _unknown, _event, _result, _count, getn.Nvalue);
					 
					//e1.print();
					e1.writeFile(result_file_writer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			if( result_file_writer != null) {
				result_file_writer.close();
				result_file_writer = null;
			}
			//ret = 0;
		} catch ( IOException e) {
			System.err.println(e);
		}		
		
	}

}


class evidence{

	String id;
	String time;
	String unknown;
	String event;
	String result;
	String count;
	 
	HashMap<String,String> getNlist;
	
	
	
	
	public evidence(String id, String time, String unknown, String event, String result, String count, HashMap<String,String> h) {
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.time = time;
		this.unknown = unknown;
		this.event = event;
		this.result = result;
		this.count = count;
		
		getNlist = h;
		
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("result = "+result);
		
		
	}
	
	
	
	public void writeFile(BufferedWriter result_file_writer){
		
		StringTokenizer str = new StringTokenizer(result, ":");
		
		String total = Integer.toString(Config.total_attacks);
		
		try {
			if( result_file_writer != null) {
				result_file_writer.write("id,time,time_period,attack_name,total events, event_id,event_count, occurences,Total attack,TF,IDF,TFIDF" +"\n");
			}
			//ret = str.length() + 2;
		} catch ( IOException e) {
			System.err.println(e);
		}	
		
		while(str.hasMoreTokens()){
			
			StringTokenizer mv = new StringTokenizer(str.nextToken(),"=");
			
			String eName = mv.nextToken();
			String eCount = mv.nextToken();
			
			String includeC = getNlist.get(eName);
			
			
			/*
			String writeLine = new String(id + "," + time +","+unknown + ","+event+","+count+","+ eName +","+ eCount+","+
											includeC + ","+total+ ","+ calculateTF(eCount, count) +","+IDF(includeC, total )
											+  "\n");
			*/
			
			String tf = calculateTF(eCount, count);
			
			String idf = IDF(includeC , total);
			
			String tfidf = IFIDF(tf, idf);
			
			String writeLine = new String(id + "," + time +","+unknown + ","+event+","+count+","+ eName +","+ eCount+","+
					includeC + ","+total+ ","+ tf + "," + idf + "," + tfidf
					
					);
			
			
			System.out.println(writeLine);
			
			try {
				if( result_file_writer != null) {
					result_file_writer.write(writeLine +"\n");
				}
				//ret = str.length() + 2;
			} catch ( IOException e) {
				System.err.println(e);
			}		
			
		}
		
	}

	private String IFIDF(String tf, String idf) {
		// TODO Auto-generated method stub
		
		double res = (Double.parseDouble(tf) * Double.parseDouble(idf));
		return Double.toString(res);
	}

	private String IDF(String includeC, String total) {
		// TODO Auto-generated method stub
		
		
		return Double.toString(Math.log(Double.parseDouble(total) / Double.parseDouble(includeC)));
	}

	private String calculateTF(String eCount, String count2) {
		// TODO Auto-generated method stub
		
		double res = 0.5 + (0.5) * (Double.parseDouble(eCount) / Double.parseDouble(count2));
		
		return Double.toString(res);
	}
	
	//public evidence(String id, String t)
}

