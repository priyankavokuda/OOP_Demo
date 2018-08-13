package de.exxcellent.file;

import util.CSVDataReader;

import java.util.ArrayList;

/**
 * class which represents weather data from csv file with header names as
 * attributes and performs class specific functions.
 * 
 * @author priyanka
 * 
 */
public class WeatherData extends Data {
	String day;
	float mxT;
	float mnT;
	int avT;
	float avDP;
	int hrPTPcpn;
	int pDir;
	float avSp;
	int dir;
	int mxS;
	float skyC;
	int mxR;
	int mn;
	float rAvSLP;

	/**
	 * empty constructor
	 */
	public WeatherData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor
	 */
	public WeatherData(String day, int mxT, int mnT, int avT, float avDP,
			int hrPTPcpn, int pDir, float avSp, int dir, int mxS, float skyC,
			int mxR, int mn, float rAvSLP) {
		super();
		this.day = day;
		this.mxT = mxT;
		this.mnT = mnT;
		this.avT = avT;
		this.avDP = avDP;
		this.hrPTPcpn = hrPTPcpn;
		this.pDir = pDir;
		this.avSp = avSp;
		this.dir = dir;
		this.mxS = mxS;
		this.skyC = skyC;
		this.mxR = mxR;
		this.mn = mn;
		this.rAvSLP = rAvSLP;
	}

	public String getDay() {
		return day;
	}

	public float getMxT() {
		return mxT;
	}
	
	public float getMnT() {
		return mnT;
	}

	/**
	 * Reads CSV file given the name of file and returns the contents of file
	 * with each row stored as class objects and all rows stored in ArrayList
	 * 
	 * @param fileName
	 * @return data stored as class objects in ArrayList
	 */
	public ArrayList<WeatherData> parseContentfromCSV(String fileName) {
		// TODO Auto-generated method stub
		ArrayList<String[]> fileContents = super.parseContentfromCSV(fileName);
		ArrayList<WeatherData> contents = new ArrayList<WeatherData>();
		for (int i = 0; i < fileContents.size(); i++) {
			WeatherData wd = new WeatherData(fileContents.get(i)[0],
					Integer.parseInt(fileContents.get(i)[1]),
					Integer.parseInt(fileContents.get(i)[2]),
					Integer.parseInt(fileContents.get(i)[3]),
					Float.parseFloat(fileContents.get(i)[4]),
					Integer.parseInt(fileContents.get(i)[5]),
					Integer.parseInt(fileContents.get(i)[6]),
					Float.parseFloat(fileContents.get(i)[7]),
					Integer.parseInt(fileContents.get(i)[8]),
					Integer.parseInt(fileContents.get(i)[9]),
					Float.parseFloat(fileContents.get(i)[10]),
					Integer.parseInt(fileContents.get(i)[11]),
					Integer.parseInt(fileContents.get(i)[12]),
					Float.parseFloat(fileContents.get(i)[13]));
			contents.add(wd);
		}
		return contents;
	}

	/**
	 * Finds temperature spread during the day.
	 * This is an overloaded function.
	 * @param contents
	 * @return arraylist containing difference max and min temperatures during
	 *         day
	 */
	public ArrayList<Integer> findDiffrOfCols(
			ArrayList<WeatherData> contents) {
		ArrayList<Integer> temprSpread = new ArrayList<Integer>();
		ArrayList<Float> minTempr = new ArrayList<Float>();
		ArrayList<Float> maxTempr = new ArrayList<Float>();
		for (WeatherData wd : contents) {
			minTempr.add(wd.getMxT());
		}
		for (WeatherData wd : contents) {
			maxTempr.add(wd.getMnT());
		}
		temprSpread = super.findDiffrOfCols(maxTempr, minTempr);
		return temprSpread;
	}

}