import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class htest {

	public htest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cvsdata = new String("tf3.csv");
		
		CSVReader reader;
		
		
		String[] dataline;
		
		String currentID = "1";
	
		//Map<int, double[config.event_num]> matrixList = new Map<int, double[config.event_num]>();
		
		HashMap<String, Double[]> m = new HashMap<String, Double[]>();
		
		
		Double[] aaa = new Double[3];
		
		aaa[0] = 1.2;
		aaa[1] = 2.3;
		aaa[2] = 3.2;
				
				
		Double[] bbb = new Double[3];
		
		bbb[0] = 8.7;
		bbb[1] = 66.9;
		bbb[2] = 99.7;
		
		String q1 = "1";
		String q2 = "2";
		
		bbb = aaa.clone();
		
		m.put(q1, bbb);
		
		aaa[0] = 564.5;
		aaa[1] = 453.4;
		aaa[2] = 345.5;
		
		
		m.put(q2, aaa);
		
		
		
		
		HashMap<String, Double[]> pList = m;
		
		for(int i = 1 ; i<= pList.size() ; i++){
			
			Double[] v = pList.get(Integer.toString(i));
		
			for(int j = 0; j < v.length ; j++){
				
				System.out.print(v[j]+" ,");
			}
			
			System.out.println();
		}
		
		
	
		
	}
	

}
