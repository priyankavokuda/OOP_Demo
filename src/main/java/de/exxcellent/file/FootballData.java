/**
 * 
 */
package de.exxcellent.file;

import java.util.ArrayList;

import util.CSVDataReader;

/**
 * class which represents football data from csv file with header names as
 * attributes and performs class specific functions.
 * 
 * @author priyanka
 * 
 */
public class FootballData extends Data{
	String team;
	int games;
	int wins;
	int losses;
	int draws;
	int goals;
	int goalsAllowed;
	int points;

	public FootballData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FootballData(String team, int games, int wins, int losses,
			int draws, int goals, int goalsAllowed, int points) {
		super();
		this.team = team;
		this.games = games;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
		this.goals = goals;
		this.goalsAllowed = goalsAllowed;
		this.points = points;
	}

	public int getGoals() {
		return goals;
	}

	public int getGoalsAllowed() {
		return goalsAllowed;
	}
	
	public String getTeam() {
		return team;
	}
	
	/**
	 * Reads CSV file given the name of file and returns the contents of file
	 * with each row stored as class objects and all rows stored in ArrayList
	 * 
	 * @param fileName
	 * @return data stored as class objects in ArrayList
	 */
	public ArrayList<FootballData> parseContentfromCSV(String fileName) {
		// TODO Auto-generated method stub
		ArrayList<String[]> fileContents = super.parseContentfromCSV(fileName);
		ArrayList<FootballData> contents = new ArrayList<FootballData>();
		for (int i = 0; i < fileContents.size(); i++) {
			FootballData fd = new FootballData(fileContents.get(i)[0],
					Integer.parseInt(fileContents.get(i)[1]),
					Integer.parseInt(fileContents.get(i)[2]),
					Integer.parseInt(fileContents.get(i)[3]),
					Integer.parseInt(fileContents.get(i)[4]),
					Integer.parseInt(fileContents.get(i)[5]),
					Integer.parseInt(fileContents.get(i)[6]),
					Integer.parseInt(fileContents.get(i)[7]));
			contents.add(fd);
		}
		return contents;
	}
	
	/**
	 * finds distance (absolute difference) between ‘Goals’ and ‘Goals Allowed’.
	 * This is an overloaded function.
	 * @param contents
	 * @return arraylist containing difference Goals and Goals Allowed 
	 */
	public ArrayList<Integer> findDiffrOfCols(
			ArrayList<FootballData> contents) {
		ArrayList<Integer> smallestDist = new ArrayList<Integer>();
		ArrayList<Integer> goals = new ArrayList<Integer>();
		ArrayList<Integer> goalsAllowed = new ArrayList<Integer>();
		for (FootballData fd : contents) {
			goals.add(fd.getGoals());
		}
		for (FootballData fd : contents) {
			goalsAllowed.add(fd.getGoalsAllowed());
		}
		smallestDist = super.findDiffrOfCols(goals, goalsAllowed);
		return smallestDist;
	}
	

}
