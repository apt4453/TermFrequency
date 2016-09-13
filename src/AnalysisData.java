import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import au.com.bytecode.opencsv.CSVReader;

public class AnalysisData {

	HashMap<Integer, Double[]> mList = new HashMap<Integer, Double[]>();
	
	HashMap<Integer, String> timeList = new HashMap<Integer, String>();
	
	
	CosineSimilarity cs = new CosineSimilarity();
	
	
	
	public AnalysisData(HashMap<Integer, Double[]> m) {
		// TODO Auto-generated constructor stub
		
		mList = m;
		
		matrixCount();
		
		cs = new CosineSimilarity();
		
	}
	
	public void setTimeList(HashMap<Integer, String> t){
		
		timeList = t;
		
		
		for(int i = 0 ; i< timeList.size() ; i++){
			
			System.out.println(i +" : " + timeList.get(i));
			
		}
		
		
	}

	
	public void matrixCount(){
		
		System.out.println("Matrix list : " + mList.size());
	}
	
	private void print() {
		// TODO Auto-generated method stub
		
	
		HashMap<Integer, Double[]> pList = mList;
		
		for(int i = 1 ; i<= pList.size() ; i++){
			
			Double[] v = pList.get(i);
		
			System.out.print("double[] p"+i+ " = {");
			
			for(int j = 0; j < v.length ; j++){
				
				System.out.print(v[j]+",");
			}
			
			System.out.println("");
		}
		
		//System.out.println(mList);
		
				
				
		
	}

	
	
	
	private void analysis() {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < timeList.size() ; i++){
			
			String time = timeList.get(i);
			
			if(time.startsWith("2016-06")){
				
				Double[] now = mList.get(i);
				
				System.out.println("\nID : "+i + " -----------------");
				
				for(int j = 1 ; j < mList.size() ; j++){
					
					String tt = timeList.get(j);
					Double[] set = mList.get(j);
					
					
					//if(!tt.startsWith("2016-06")){
						
						
						Double result = cs.cosineSimilarity(now, set);
						
						if(result > ( Config.similarity_threshold)) {
							
							
							//if(i< 200){
							
								System.out.println(j + "," +result);
							//}
						}
					//}
					
				}
				
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String cvsdata = new String(Config.tf_out_file);
		
		CSVReader reader;
		
		
		String[] dataline;
		
		String currentID = "1";
	
		//Map<int, double[config.event_num]> matrixList = new Map<int, double[config.event_num]>();
		
		HashMap<Integer, Double[]> matrixList = new HashMap<Integer, Double[]>();
		
		HashMap<Integer, String> occurTimeList = new HashMap<Integer, String>();
		
		Double[] matrix = new Double[Config.event_num];
		
		for(int i = 0 ; i<matrix.length ; i++){
			
			matrix[i] = 0.0;
		}
		
		//firstline
	
		
		try{
			
			reader = new CSVReader(new FileReader(cvsdata));
			
			reader.readNext();
			
			
			while ((dataline = reader.readNext()) != null) {
				
				//HashMap<String, Double> hash = new HashMap<String, Double>();
				
			
				
				String id = dataline[0].trim();
				String time = dataline[1].trim();
				String name = dataline[3].trim();
				String em = dataline[5].trim();
				//DOuble idf = dataline[]
				
				if(!id.equals("id")){
				
					if(!occurTimeList.containsKey(id)){
						
						//System.out.println("Time : " + time);
						occurTimeList.put(Integer.parseInt(id), time);
					}
					
					if(currentID.equals(id)){
						
						
						//if(Double.parseDouble(dataline[10].trim()) > 1){
							matrix[ Integer.parseInt(em.substring(1)) ] = new Double(dataline[Config.tfidf].trim());
						//}
					}
					
					else{
						
						
						
						
					
						Double[] m = matrix.clone();
						
						matrixList.put(Integer.parseInt(currentID), m);
						Double[] v = matrixList.get(currentID);
						
				
						
						currentID = id;
						
						//System.out.println("Now Current ID : "+currentID);
						
						for(int i = 0 ; i<matrix.length ; i++){
							
							matrix[i] = 0.0;
						}
						
						matrix[ Integer.parseInt(em.substring(1)) ] = new Double(dataline[Config.tfidf].trim());
						
						
						//if(currentID.equals("1"))
							
						//}
						//else{
							
					
					
						
						//temp
						/*
						HashMap<String, Double[]> pList = matrixList;
						
						for(int i = 1 ; i<= pList.size() ; i++){
							
							Double[] v = pList.get(Integer.toString(i));
						
							for(int j = 0; j < v.length ; j++){
								
								System.out.print(v[j]+",");
							}
							
							System.out.println();
						}
						
						*/
						
						
						
						
						
					}
					
					/*
					if(currentID != Integer.parseInt(id)){
						
						currentID = Integer.parseInt(id);
						
						//int hashmap
						for(int i = 0 ; i<config.event_num ; i++){
							
							hash.put("e"+Integer.toString(i+1), new Double(0));
						}
						
						hash.put(em, Double.parseDouble(dataline[15].trim()));
						
					}
					
					else{
						
						hash.put(em, Double.parseDouble(dataline[15].trim()));
					}*/
					
					
				}
				
				
				//last
				matrixList.put(Integer.parseInt(currentID), matrix);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("Enter the return");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AnalysisData mat = new AnalysisData(matrixList);
		
		
		mat.print();
		
		mat.setTimeList(occurTimeList);
		
		
		////////
		
		
		mat.analysis();
		
		
		
		
	}


	
}
