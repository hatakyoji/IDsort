package IDsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	BufferedReader br = null;
    	BufferedReader br2 = null;
    	int i = 0;
		int j = 0;
		int k = 0;
		int m = 0;
    	int roop = 0;
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	HashMap<String,Integer> mapNEW = new HashMap<String,Integer>();
    	ArrayList<String>array = new ArrayList<String>();
    	ArrayList<String>arrayTH = new ArrayList<String>();
    	ArrayList<String>arrayCO2 = new ArrayList<String>();
    	ArrayList<String>arrayPIR = new ArrayList<String>();
    	ArrayList<String>arrayTMP = new ArrayList<String>();
    	ArrayList<String>arrayILL = new ArrayList<String>();
    	ArrayList<String>arrayOPN = new ArrayList<String>();
    	ArrayList<String>arraySWI = new ArrayList<String>();
    	ArrayList<String>arrayNEW = new ArrayList<String>();

        File file = new File("C:/Users/kyoji-ha/Desktop/sumaha_編集用/ロームdata/rohm-all.csv");
        FileWriter fw;
        
        //ここに解析したいファイルを指定する
        //File file2 = new File("C:/Users/kyoji-ha/Desktop/log2016-02-12-13_all.csv");
        
		try {
			fw = new FileWriter("C:/Users/kyoji-ha/Desktop/output.csv", true);
	      	PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
	        br = new BufferedReader(new FileReader(file));
	    	br2 = new BufferedReader(new FileReader(file));

	    	String line;
	    	String line2;
	    	String t;
	    	
	    	
            while ((line = br.readLine()) != null) {
            	String[] split = line.split(",",-1);
            	if(split[2].equals("ID")){
            		;
            	}else if(split[3].indexOf("LRN") != -1){
            		;
            	}else{
            		if(map.containsKey(split[2])){
            				;
            		}else{
            			map.put(split[2],j);
            			j++;
            			if(split[3].equals("TH")){
            				array.add("TH_ondo_" + split[2]);
            				i++;
            				array.add("TH_situdo_" + split[2]);
            				map.put("TH_situdo_" + split[2],j);
            				i++;
            				j++;
            			}else if(split[3].equals("CO2")){
            				array.add("CO2_noudo_" + split[2]);
            				i++;
            				array.add("CO2_ondo_" + split[2]);
            				map.put("CO2_ondo" + split[2],j);
            				i++;
            				j++;
            				array.add("CO2_situdo_" + split[2]);
            				map.put("CO2_situdo_" + split[2],j);
            				i++;
            				j++;
            			}else if(split[3].equals("PIR")){
            				array.add("PIR_" + split[2]);
            				i++;
            			}else if(split[3].equals("TMP")){
            				array.add("TMP_" + split[2]);
            				i++;
            			}else if(split[3].equals("ILL")){
            				array.add("ILL_" + split[2]);
            				i++;
            			}else if(split[3].equals("OPN")){
            				array.add("OPN_" + split[2]);
            				i++;
            			}else if(split[3].equals("SWI")){
            				array.add("SWI_" + split[2]);
            				i++;
            			}

            		}
            	}
            }
        	
        	pw.print("time,");

        	for(String s : array){
        		if(s.matches(".*"+"TH"+".*")){
        			arrayTH.add(s);
        		}else if (s.matches(".*"+"CO2"+".*")) {
					arrayCO2.add(s);
				}else if (s.matches(".*"+"PIR"+".*")) {
					arrayPIR.add(s);
				}else if (s.matches(".*"+"TMP"+".*")) {
					arrayTMP.add(s);
				}else if (s.matches(".*"+"ILL"+".*")) {
					arrayILL.add(s);
				}else if (s.matches(".*"+"OPN"+".*")) {
					arrayOPN.add(s);
				}else if (s.matches(".*"+"SWI"+".*")) {
					arraySWI.add(s);
				}
        	}
        	
        	arrayNEW.addAll(arrayTH);
        	arrayNEW.addAll(arrayCO2);
        	arrayNEW.addAll(arrayPIR);
        	arrayNEW.addAll(arrayTMP);
        	arrayNEW.addAll(arrayILL);
        	arrayNEW.addAll(arrayOPN);
        	arrayNEW.addAll(arraySWI);
        	
        	System.out.println("addしたよ");
        	
        	for(k=0;k<arrayNEW.size();k++){
        		pw.print(arrayNEW.get(k) + ",");
        		mapNEW.put(arrayNEW.get(k), k);
        	}
        	
        	System.out.println("pw.printしたよ");
        	
            while ((line2 = br2.readLine()) != null) {
            	String[] split2 = line2.split(",",-1);
            	if(split2[2].equals("ID")){
            		;
            	}else if(split2[3].indexOf("LRN") != -1){
            		;
            	}else{
            		pw.print("\n");
            		pw.print(split2[0]+" "+split2[1]+",");
            		m=0;
            		
            		while (m!=k){
            			t=arrayNEW.get(m);
                		if(t.matches(".*"+split2[2]+".*")){
                			if(split2[3].equals("TH")){
            					pw.print(split2[4]+","+split2[5]+",");
            					m++;
            				}else if(split2[3].equals("CO2")){
            					pw.print(split2[4]+","+split2[5]+","+split2[6]+",");
            					m=m+2;
            				}else if(split2[3].equals("SWI")){
            					pw.print(split2[5]+",");
            				}else if(split2[3].equals("ILL")){
            					pw.print(split2[4]+",");
            				}else if(split2[3].equals("OPN")){
            					pw.print(split2[4]+",");
            				}else{
            					pw.print("1,");
            				}
            			}else{
            				pw.print(",");
            			}
            			m++;
            		}

        		}
            }
        	
        	pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}  //※１
		finally {
        try {
			br.close();
			br2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
        roop = i+1;
		
		System.out.println(roop+"列分データがありあました");  


	}

}
