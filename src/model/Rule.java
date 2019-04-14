package model;

import java.util.HashMap;
import java.util.Map.Entry;

public class Rule {
    public int number;
    public int k;

    public Rule(int number) {
        this(number, 3);
    }

    public Rule(int number, int k) {
        this.number = number;
        this.k = k;
    }

    public int getNumber() {
        return this.number;
    }

    public String getBinaryNumber() {
    	return this.getBinaryNumber(this.number, (int) Math.pow(2, k));
    }
    
    public String getBinaryNumber(int num, int size) {
    	String s = Integer.toBinaryString(num);
    	
    	while (s.length() < size) {
    		s = "0" + s;
    	}
    	
    	return s;
    }
    
    public char getCharAt(int i) {
    	return this.getBinaryNumber().charAt(i);
    }

    public HashMap<Integer, Boolean> getPattern() {
        HashMap<Integer, Boolean> map = new HashMap<>();
        Boolean b = false;
        
        String substr;
        for(int i = 0; i < this.getBinaryNumber().length(); i++) {
        	for (int j = 0; j < this.getK(); j++) {
        		b = (this.getCharAt(i) == 1);
        	}
        		
        	map.put(new Integer(i), b);
        }

        return map;
    }
    
    public int getK() {
    	return this.k;
    }
    
    @Override
    public String toString() {
    	HashMap<Integer, Boolean> map = this.getPattern();
    	StringBuilder s = new StringBuilder();
 
    	s.append("{\n");
    	for(Entry<Integer, Boolean> m: map.entrySet()) {
    		s.append("    '" + this.getBinaryNumber(m.getKey(), this.getK()) + "' -> [");
    		
    		for (int i = 0; i < m.getValue().length -1; i++) {
    			s.append(m.getValue()[i] + ", ");
    		}
    		s.append(m.getValue()[m.getValue().length-1] + "]\n");
    	}
    	s.append("}");
    	
    	return s.toString();
    }
}