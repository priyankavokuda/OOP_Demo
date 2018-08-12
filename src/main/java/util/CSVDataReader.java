package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * utility class to read csv files
 * 
 * @author priyanka
 * 
 */
public class CSVDataReader implements DataReader {
	String csvFileName;
	String delimiter = ",";

	public void setCsvFileName(String csvFileName) {
		this.csvFileName = csvFileName;
	}

	/**
	 * Reads CSV file given the name of file and returns the contents of file
	 * with each row stored in String array and all rows stored in ArrayList
	 * 
	 * @param fname
	 * @return data stored as sring objects in ArrayList
	 */
	public ArrayList<String[]> readContents(String fname) {
		String line = "";
		ArrayList<String[]> contents = new ArrayList<String[]>();
		setCsvFileName(fname);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(csvFileName));
			String headerLine = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] data = line.split(delimiter);
				contents.add(data);
			}
			br.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;
	}
}