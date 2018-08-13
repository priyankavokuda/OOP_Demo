package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Base Class storing basic information and actions performed on a file for this challenge
 * 
 * @author priyanka
 * @param <T>
 *
 */
public class Data<T> {
	String fname = null;
	float size = 0;
	
	public ArrayList parseContentfromCSV(String fname){
		return null;
		
	}
	/**
	 * function performs subtraction of two columns of csv file
	 * @return arraylist
	 */
	public ArrayList<Integer> findDiffrOfCols() {
		ArrayList<Integer> temprSpread = new ArrayList<Integer>();
		return temprSpread;
	}
	/**
	 * function finds the index of the minimum element from arraylist
	 * @param diffr
	 * @return index
	 */
	public int findMinOfColumn(ArrayList<Integer> diffr) {
		int minIndex = diffr.indexOf(Collections.min(diffr));
		return minIndex;
	}


}
