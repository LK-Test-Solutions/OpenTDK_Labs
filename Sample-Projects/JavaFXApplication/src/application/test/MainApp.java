package application.test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

import org.opentdk.api.logger.MLogger;
import org.opentdk.gui.application.BaseApplication;

import javafx.application.Platform;

public class MainApp extends BaseApplication { 
	
	private SampleController controller;

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void init() throws Exception {
		// Obligatory if used below
		super.setResourceBundle(ResourceBundle.getBundle("application.test.Bundle", new Locale("en")));
		// Optional
		super.setStyleSheet("application.css");
		super.setWidth(1000);
		super.setHeight(600);

		super.init();
	}

	@Override
	protected void showRootLayout() {
		try {
			controller = (SampleController) super.showStage("Sample.fxml", super.getBundle().getString("application.title"), super.getPrimaryStage());
			controller.reload();
		} catch (IOException e) {
			MLogger.getInstance().log(Level.SEVERE, e);
			Platform.exit();
		}
	}

}
