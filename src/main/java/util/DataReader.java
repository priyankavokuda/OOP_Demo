package util;

import java.util.ArrayList;

/**
 * Utility class to read files
 * 
 * @author priyanka
 *
 */
public interface DataReader {
	public ArrayList<String[]> readContents(String fileName);
}
