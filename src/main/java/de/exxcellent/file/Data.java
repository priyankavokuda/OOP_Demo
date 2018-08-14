package de.exxcellent.file;

import java.util.ArrayList;
import java.util.Collections;

import util.CSVDataReader;

/**
 * Base Class storing basic information and actions performed on a file for this challenge
 * 
 * @author priyanka
 *
 *
 */
public class Data<T> {
	String fileName = null;
	float size = 0;
	
	
	/**
	 * This function is associated with CSVDataReader and gets the contents of file in form of String[]
	 * @param fileName
	 * @return ArrayList<String[]>
	 */
	public ArrayList<String[]> parseContentfromCSV(String fileName) {
		CSVDataReader csvReader = new CSVDataReader();
		ArrayList<String[]> fileContents = csvReader.readContents(fileName);
		return fileContents;

	}
	/**
	 * function performs subtraction of two columns of csv file
	 * @return arraylist
	 */
	public ArrayList<Number> findDiffrOfCols(ArrayList<Number> col1,ArrayList<Number> col2) {
		ArrayList<Number> diffr = new ArrayList<Number>();
	
		if(col1.size()==col2.size()){
			for (int i = 0; i < col1.size(); i++) {
				if(col1.get(i) instanceof Double || col2.get(i) instanceof Double) {
					diffr.add(Math.abs(col1.get(i).doubleValue() - col2.get(i).doubleValue()));
				}
			    else if(col1.get(i) instanceof Float || col2.get(i) instanceof Float) {
			    	diffr.add(Math.abs(col1.get(i).floatValue() - col2.get(i).floatValue()));
			    }
			    else if(col1.get(i) instanceof Integer || col2.get(i) instanceof Integer) {
			    	diffr.add(Math.abs(col1.get(i).intValue() - col2.get(i).intValue()));
			    }
		}
		}
		return diffr;
	}
	/**
	 * function finds the index of the minimum element from arraylist
	 * @param diffr
	 * @return index
	 */
	public int findArgMinOfColumn(ArrayList<?> col) {
		int minIndex = -1;
		if(col.get(1) instanceof Integer){
			ArrayList<Integer> intCol = (ArrayList<Integer>) col;
			minIndex = intCol.indexOf(Collections.min(intCol));
		}
		if(col.get(1) instanceof Float){
			ArrayList<Float> floatCol = (ArrayList<Float>) col;
			minIndex = floatCol.indexOf(Collections.min(floatCol));
		}
		if(col.get(1) instanceof Double){
			ArrayList<Double> doubleCol = (ArrayList<Double>) col;
			minIndex = doubleCol.indexOf(Collections.min(doubleCol));
		}
		return minIndex;
	}


}
