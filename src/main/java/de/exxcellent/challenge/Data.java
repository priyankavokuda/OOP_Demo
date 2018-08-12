package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Base Class storing basic information and actions performed on a file for this challenge
 * 
 * @author priyanka
 *
 */
public class Data {
	String fname = null;
	float size = 0;
	
	public ArrayList parseContentfromCSV(String fname){
		return null;
		
	}
	public int findMinOfColumn(ArrayList<Integer> diffr) {
		int minIndex = diffr.indexOf(Collections.min(diffr));
		return minIndex;
	}
}
