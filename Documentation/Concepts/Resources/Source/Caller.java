package lk.opentdkdemo;

import java.io.File;

/**
 * Caller simulation for the {@link lk.tutorium.Tutorium} class.
 * 
 * @author LK Test Solutions
 *
 */
public class Caller {

	public static void main(String[] args) {
		String[] params = { "testdata" + File.separator + "testdata.txt", "Time", "Percentage" };
		Tutorium.main(params);
	}

}