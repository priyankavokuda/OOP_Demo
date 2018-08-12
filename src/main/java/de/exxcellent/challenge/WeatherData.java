package de.exxcellent.challenge;

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
	int mxT;
	int mnT;
	float avT;
	float avDP;
	int hrPTPcpn;
	int pDir;
	float avSp;
	int dir;
	float mxS;
	float skyC;
	float mxR;
	float mn;
	float rAvSLP;

	/**
	 * empty constructor
	 */
	public WeatherData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * parameterised constructor
	 */
	public WeatherData(String day, int mxT, int mnT, float avT, float avDP,
			int hrPTPcpn, int pDir, float avSp, int dir, float mxS, float skyC,
			float mxR, float mn, float rAvSLP) {
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

	public void setDay(String day) {
		this.day = day;
	}

	public int getMxT() {
		return mxT;
	}

	public void setMxT(int mxT) {
		this.mxT = mxT;
	}

	public int getMnT() {
		return mnT;
	}

	public void setMnT(int mnT) {
		this.mnT = mnT;
	}

	public float getAvT() {
		return avT;
	}

	public void setAvT(float avT) {
		this.avT = avT;
	}

	public float getAvDP() {
		return avDP;
	}

	public void setAvDP(float avDP) {
		this.avDP = avDP;
	}

	public int getHrPTPcpn() {
		return hrPTPcpn;
	}

	public void setHrPTPcpn(int hrPTPcpn) {
		this.hrPTPcpn = hrPTPcpn;
	}

	public int getpDir() {
		return pDir;
	}

	public void setpDir(int pDir) {
		this.pDir = pDir;
	}

	public float getAvSp() {
		return avSp;
	}

	public void setAvSp(float avSp) {
		this.avSp = avSp;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public float getMxS() {
		return mxS;
	}

	public void setMxS(float mxS) {
		this.mxS = mxS;
	}

	public float getSkyC() {
		return skyC;
	}

	public void setSkyC(float skyC) {
		this.skyC = skyC;
	}

	public float getMxR() {
		return mxR;
	}

	public void setMxR(float mxR) {
		this.mxR = mxR;
	}

	public float getMn() {
		return mn;
	}

	public void setMn(float mn) {
		this.mn = mn;
	}

	public float getrAvSLP() {
		return rAvSLP;
	}

	public void setrAvSLP(float rAvSLP) {
		this.rAvSLP = rAvSLP;
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
		CSVDataReader csvReader = new CSVDataReader();
		ArrayList<String[]> fileContents = csvReader.readContents(fileName);
		ArrayList<WeatherData> contents = new ArrayList<WeatherData>();
		for (int i = 0; i < fileContents.size(); i++) {
			WeatherData wd = new WeatherData();
			wd.setDay(fileContents.get(i)[0]);
			wd.setMxT(Integer.parseInt(fileContents.get(i)[1]));
			wd.setMnT(Integer.parseInt(fileContents.get(i)[2]));
			wd.setAvT(Float.parseFloat(fileContents.get(i)[3]));
			wd.setAvDP(Float.parseFloat(fileContents.get(i)[4]));
			wd.setHrPTPcpn(Integer.parseInt(fileContents.get(i)[5]));
			wd.setpDir(Integer.parseInt(fileContents.get(i)[6]));
			wd.setAvSp(Float.parseFloat(fileContents.get(i)[7]));
			wd.setDir(Integer.parseInt(fileContents.get(i)[8]));
			wd.setMxS(Float.parseFloat(fileContents.get(i)[9]));
			wd.setSkyC(Float.parseFloat(fileContents.get(i)[10]));
			wd.setMxR(Float.parseFloat(fileContents.get(i)[11]));
			wd.setMn(Float.parseFloat(fileContents.get(i)[12]));
			wd.setrAvSLP(Float.parseFloat(fileContents.get(i)[13]));
			contents.add(wd);
		}
		return contents;
	}

	/**
	 * finds temperature spread during the day
	 * 
	 * @param contents
	 * @return arraylist containing difference max and min temperatures during
	 *         day
	 */
	public ArrayList<Integer> findTemprDifference(
			ArrayList<WeatherData> contents) {
		ArrayList<Integer> temprSpread = new ArrayList<Integer>();
		for (WeatherData wd : contents) {
			temprSpread.add(wd.getMxT() - wd.getMnT());
		}
		return temprSpread;
	}
	
	@Override
	public int findMinOfColumn(ArrayList<Integer> diffr) {
		int min=super.findMinOfColumn(diffr);
		return min;
	}

}