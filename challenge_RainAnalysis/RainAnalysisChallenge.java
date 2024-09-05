/**
 * 
 */
package challenge_RainAnalysis;

import java.util.Arrays;

/**
 * 
 */
public class RainAnalysisChallenge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declare and Initialise Variables

		int total = 0;
		double rainfallAveragePerDay = 0;

		// a 2D array for monthly rainfall data in mm per day in each month
		int[][] monthlyRainfall = {
				// January (31 days)
				{ 12, 8, 23, 4, 0, 9, 2, 3, 11, 14, 7, 18, 15, 1, 0, 2, 4, 0, 1, 1, 0, 0, 1, 0, 10, 3, 2, 0, 0, 0, 3 },
				// February (28 days)
				{ 3, 6, 9, 5, 7, 2, 4, 7, 6, 8, 7, 9, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 2, 0, 9, 8, 0, 6 },
				// March (31 days)
				{ 1, 8, 0, 11, 8, 5, 7, 8, 4, 3, 7, 6, 5, 9, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				// April (30 days)
				{ 3, 6, 5, 4, 8, 9, 6, 4, 3, 7, 6, 5, 8, 7, 6, 5, 9, 4, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 2 },
				// May (31 days)
				{ 2, 5, 8, 7, 6, 9, 8, 2, 7, 5, 3, 6, 8, 9, 4, 6, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2 },
				// June (30 days)
				{ 0, 6, 5, 8, 9, 6, 4, 7, 6, 5, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				// July (31 days)
				{ 1, 6, 0, 9, 7, 6, 5, 4, 8, 9, 6, 5, 7, 7, 4, 6, 8, 7, 5, 3, 7, 9, 8, 6, 5, 9, 0, 0, 2, 0, 0 },
				// August (31 days)
				{ 7, 6, 5, 8, 9, 6, 5, 4, 7, 6, 5, 9, 0, 0, 2, 0, 0, 0, 2, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0 },
				// September (30 days)
				{ 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 0, 0, 1, 9, 1, 1, 0, 0, 0, 0, 2, 3, 8, 0, 0, 0, 1, 1, 0, 0 },
				// October (31 days)
				{ 2, 5, 0, 0, 6, 0, 0, 0, 0, 5, 3, 0, 0, 0, 4, 6, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0 },
				// November (30 days)
				{ 7, 0, 5, 4, 8, 9, 6, 4, 3, 7, 6, 5, 8, 7, 6, 5, 9, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0 },
				// December (31 days)
				{ 2, 5, 8, 7, 6, 9, 8, 7, 5, 6, 3, 6, 9, 1, 2, 3, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 0, 1 } };

		System.out.println("_______________________________________________-");
		System.out.println();
		
		// Print 2D Array
		print2DArrayToConsole(monthlyRainfall);

		// Heaviest day rain total

		int currentMax = findHeaviestDayRainTotal(monthlyRainfall);
		System.out.println("Heaviest day rain total : " + currentMax + "(mm)");
		System.out.println();

		// Total of rain in year

		total = totalRainInYear(monthlyRainfall);
		System.out.println("Total of rain in year : " + total + "mm");
		System.out.println();

		// Rainfall average per day

		rainfallAveragePerDay = rainfallAveragePerDay(total, monthlyRainfall);
		System.out.printf("Rainfall average per day : %.2f (mm)\n", rainfallAveragePerDay);
		System.out.println();

		// Total days rain per month

		printTotalDaysRainPerMonth(monthlyRainfall);

		// Month with most rain

		int mostRain = findMonthWithMaximumTotalRainfall(monthlyRainfall);

		System.out.println();

		String monthOfMostRain = switchStatementToReturnMonth(mostRain);
		System.out.println("Month with most rain by volume : " + monthOfMostRain);
		System.out.println();

		// Rain visual

		printOrderedRainVisualToConsoleExcludingZeroValues(monthlyRainfall);
	}

	/**
	 * This method prints the ordered rain visual (excluding zero values) to the
	 * console. It has a previously used method included to convert the index of a
	 * value to the required month
	 * 
	 * @param monthlyRainfall
	 */
	public static void printOrderedRainVisualToConsoleExcludingZeroValues(int[][] monthlyRainfall) {
		System.out.println("Rain visual - mm of rain on wet days sorted (asc)");
		
		for (int i = 0; i < monthlyRainfall.length; i++) {
			ifElseStatementToPrintMonth(i);
			for (int j = 0; j < monthlyRainfall[i].length; j++) {
				Arrays.sort(monthlyRainfall[i]);
				if (monthlyRainfall[i][j] == 0) {
					continue;
				} else {
					System.out.print(monthlyRainfall[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * This switch statement converts the index for the month and returns it as a
	 * string of the month
	 * 
	 * @param mostRain
	 * @return
	 */
	public static String switchStatementToReturnMonth(int mostRain) {
		switch (mostRain) {
		case 0:
			return "Jan";
		case 1:
			return "Feb";
		case 2:
			return "Mar";
		case 3:
			return "Apr";
		case 4:
			return "May";
		case 5:
			return "Jun";
		case 6:
			return "Jul";
		case 7:
			return "Aug";
		case 8:
			return "Sep";
		case 9:
			return "Oct";
		case 10:
			return "Nov";
		case 11:
			return "Dec";
		default:
			return "Error";

		}
	}

	/**
	 * This method identifies the month with the maximum total rainfall and returns
	 * it value as an index of the month.
	 * 
	 * @param monthlyRainfall
	 * @return - mostRain as index of month
	 */
	public static int findMonthWithMaximumTotalRainfall(int[][] monthlyRainfall) {
		int mostRain = 0;
		int monthlyTotal = 0;
		int currentMaximum = 0;

		for (int i = 0; i < monthlyRainfall.length; i++) {
			for (int j = 0; j < monthlyRainfall[i].length; j++) {
				monthlyTotal += monthlyRainfall[i][j];
			}
			if (monthlyTotal > currentMaximum) {
				currentMaximum = monthlyTotal;
				mostRain = i;
			}
			monthlyTotal = 0;
		}
		return mostRain;
	}

	/**
	 * This method prints the Total Days of Rain Per Month to the console
	 * 
	 * @param monthlyRainfall
	 */
	public static void printTotalDaysRainPerMonth(int[][] monthlyRainfall) {
		System.out.println("Total days rain per month (mm)");
		for (int i = 0; i < monthlyRainfall.length; i++) {

			int rainPerMonth = 0;

			ifElseStatementToPrintMonth(i);
			for (int j = 0; j < monthlyRainfall[i].length; j++) {
				if (monthlyRainfall[i][j] == 0) {
					continue;
				} else {
					rainPerMonth++;
				}

			}
			System.out.print(rainPerMonth);
			System.out.println();
			rainPerMonth = 0;
		}
	}

	/**
	 * This method uses and ifElse Statement to print the correct month according to
	 * i. It will be embedded within other methods
	 * 
	 * @param i
	 */
	public static void ifElseStatementToPrintMonth(int i) {
		if (i == 0) {
			System.out.print("Jan\t");
		} else if (i == 1) {
			System.out.print("Feb\t");
		} else if (i == 2) {
			System.out.print("Mar\t");
		} else if (i == 3) {
			System.out.print("Apr\t");
		} else if (i == 4) {
			System.out.print("May\t");
		} else if (i == 5) {
			System.out.print("Jun\t");
		} else if (i == 6) {
			System.out.print("Jul\t");
		} else if (i == 7) {
			System.out.print("Aug\t");
		} else if (i == 8) {
			System.out.print("Sep\t");
		} else if (i == 9) {
			System.out.print("Oct\t");
		} else if (i == 10) {
			System.out.print("Nov\t");
		} else if (i == 11) {
			System.out.print("Dec\t");
		} else {
			System.out.print("Error");
		}
	}

	/**
	 * This method returns the rainfall average per day
	 * 
	 * @param total           - total rainfall per year
	 * @param monthlyRainfall
	 * @return - average rainfall per day
	 */
	public static double rainfallAveragePerDay(int total, int[][] monthlyRainfall) {
		int numberOfDaysInYear;
		double rainfallAveragePerDay;
		numberOfDaysInYear = 0;

		for (int i = 0; i < monthlyRainfall.length; i++) {
			for (int j = 0; j < monthlyRainfall[i].length; j++) {
				numberOfDaysInYear++;
			}
		}

		rainfallAveragePerDay = (double) total / numberOfDaysInYear;
		return rainfallAveragePerDay;
	}

	/**
	 * This method returns the total rainfall in the year
	 * 
	 * @param monthlyRainfall
	 * @return - total rainfall for the year
	 */
	public static int totalRainInYear(int[][] monthlyRainfall) {
		int total;
		total = 0;

		for (int i = 0; i < monthlyRainfall.length; i++) {
			for (int j = 0; j < monthlyRainfall[i].length; j++) {
				total += monthlyRainfall[i][j];
			}
		}
		return total;
	}

	/**
	 * This method returns the heaviest day rain total for the 2D Array
	 * 
	 * @param monthlyRainfall
	 * @return - Heaviest day rain total from 2D Array
	 */
	public static int findHeaviestDayRainTotal(int[][] monthlyRainfall) {
		int currentMax = monthlyRainfall[0][0];

		for (int i = 0; i < monthlyRainfall.length; i++) {
			for (int j = 0; j < monthlyRainfall[i].length; j++) {
				if (currentMax < monthlyRainfall[i][j]) {
					currentMax = monthlyRainfall[i][j];
				}
			}
		}
		return currentMax;
	}

	/**
	 * This method prints a 2D Array to console - it has the method
	 * "switchStatementToPrintMonth' embedded in it to convert i to required month
	 * 
	 * @param monthlyRainfall
	 */
	public static void print2DArrayToConsole(int[][] monthlyRainfall) {
		System.out.println("Rainfall analysis\nAll Rainfall per month (mm)\n");
		for (int i = 0; i < monthlyRainfall.length; i++) {
			switchStatementToPrintMonth(i);
			for (int j = 0; j < monthlyRainfall[i].length; j++) {
				System.out.print(monthlyRainfall[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * This method uses the value of i (current loop counter) to print the correct
	 * month to console
	 * 
	 * @param i - current loop value
	 */
	public static void switchStatementToPrintMonth(int i) {
		int month = i;

		switch (month) {
		case 0:
			System.out.print("Jan\t");
			break;
		case 1:
			System.out.print("Feb\t");
			break;
		case 2:
			System.out.print("Mar\t");
			break;
		case 3:
			System.out.print("Apr\t");
			break;
		case 4:
			System.out.print("May\t");
			break;
		case 5:
			System.out.print("Jun\t");
			break;
		case 6:
			System.out.print("Jul\t");
			break;
		case 7:
			System.out.print("Aug\t");
			break;
		case 8:
			System.out.print("Sep\t");
			break;
		case 9:
			System.out.print("Oct\t");
			break;
		case 10:
			System.out.print("Nov\t");
			break;
		case 11:
			System.out.print("Dec\t");
			break;
		default:
			System.out.print("Error");
			break;

		}
	}

}
