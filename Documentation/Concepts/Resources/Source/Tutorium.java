package lk.opentdkdemo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.opentdk.api.datastorage.DataContainer;
import org.opentdk.api.io.FileUtil;
import org.opentdk.api.logger.MLogger;

/**
 * This is a tutor application to get in touch with Java programming as well as the LK Java modules.
 * It extracts garbage collection statistics out of a sample log file.<br>
 * <br>
 * 
 * The following Java basics are part of the program:<br>
 * <br>
 * 
 * <pre>
 * Running a main class
 * Private fields
 * Initialization block
 * Constructor
 * Public methods
 * For loop
 * Catching Exceptions
 * Java documentation
 * </pre>
 * 
 * The following LK modules a part of the program:<br>
 * <br>
 * 
 * <pre>
 * org.opentdk.api.base.jar
 * </pre>
 * 
 * @author LK Test Solutions
 *
 */
public class Tutorium {

	// JAVADOC starts with slash and two stars.
	/**
	 * Entry point ==> Initialization of the main class and call of the parse method.
	 * 
	 * @param args First parameter: Path and name of the source file. Second parameter: First header of
	 *             the result CSV file. Third parameter: Second header of the result CSV file.
	 */
	public static void main(String[] args) {

		if (args.length < 2) {
			MLogger.getInstance().log(Level.SEVERE, "Not enough program parameter specified. First parameter: Path and name of the source file. " + "Second parameter: First header of the result CSV file. " + "Third parameter: Second header of the result CSV file.");
			System.exit(1);
		}
		String sourceFile = args[0];
		String firstHeader = args[1];
		String secondHeader = args[2];

		Tutorium tutorium = new Tutorium(sourceFile, firstHeader, secondHeader);
		tutorium.processData();
		System.out.println(tutorium.getResultMessage());

		System.exit(0);
	}

	// Non JAVADOC starts with slash and one star.
	/*
	 * Private fields (properties) ==> Only available in this class. Final ==> Cannot be overwritten and
	 * has to get initialized in the constructor.
	 */

	private final String sourceFile;
	private final String timeHeader;
	private final String percentageHeader;
	private String resultMessage;

	/**
	 * Make the {@link #resultMessage} accessible for other classes.
	 * 
	 * @return the status message of the program.
	 */
	public String getResultMessage() {
		return resultMessage;
	}

	/*
	 * Initialization block. Gets called before the constructor. Especially useful if there a several
	 * constructors that have similar content.
	 */
	{
		MLogger.getInstance().setLogFile("logs" + File.separator + "Tutorium.log");
		MLogger.getInstance().setTraceLevel(Level.ALL);
	}

	/**
	 * Constructor with arguments. Called when initializing this class. Parameter description see ==>
	 * {@link #main(String[])}
	 */
	public Tutorium(String srcFile, String firstHeader, String secondHeader) {
		sourceFile = srcFile;
		timeHeader = firstHeader;
		percentageHeader = secondHeader;
	}

	/**
	 * The data processing routine of the {@link #Tutorium(String, String, String)} application.
	 */
	public void processData() {
		DataContainer sourceContainer = new DataContainer(sourceFile, ";");
		DataContainer resultContainer = new DataContainer();
		resultContainer.setHeaders(new String[] { timeHeader, percentageHeader });

		for (String[] row : sourceContainer.getRowsList()) {
			String value = row[row.length - 1];

			if (value.matches("Total GC measuring \\d\\d,\\d\\d\\%")) {
				String time = row[1];
				String searchCriteria = "Total GC measuring ";
				int startPercentage = value.indexOf(searchCriteria) + searchCriteria.length();
				int endPercentage = value.indexOf("%");
				String percentage = value.substring(startPercentage, endPercentage);
				resultContainer.addRow(new String[] { time, String.valueOf(percentage) });
			}
		}

		try {
			FileUtil.checkDir("output", true);
			resultContainer.exportContainer("output" + File.separator + "testdata.csv");
			MLogger.getInstance().log(Level.INFO, "Result successfully exported to output subfolder.");
			resultMessage = "Success";
		} catch (IOException e) {
			MLogger.getInstance().log(Level.SEVERE, e);
			resultMessage = "Failure while exporting the result.";
		}
	}

}