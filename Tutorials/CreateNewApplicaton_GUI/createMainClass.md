# How to create a JavaFX main class with OpenTDK

Let's not use too many words - this is the whole class. The most important lines are marked with a number that
matches to the description below.

```
package application.test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

import org.opentdk.api.logger.MLogger;
import org.opentdk.gui.application.BaseApplication;

import javafx.application.Platform;

public class MainApp extends BaseApplication { // 1
	
	private SampleController controller; // 2

	public static void main(String[] args) {
		launch(); // 3
	}
	
	@Override
	public void init() throws Exception { // 4
		super.setResourceBundle(ResourceBundle.getBundle("application.test.Bundle", new Locale("en"))); // 5
		super.setStyleSheet("application.css"); // 6.1
		super.setWidth(1000); // 6.2
		super.setHeight(600); // 6.3
		
		super.init();
	}

	@Override
	protected void showRootLayout() {
		try {
		    // 7
		    controller = (SampleController) super.showStage("Sample.fxml", super.getBundle().getString("application.title"), super.getPrimaryStage());
		    controller.reload();
		} catch (IOException e) {
			MLogger.getInstance().log(Level.SEVERE, e);
			Platform.exit();
		}
	}

}
```

1. The class inherits from <code>org.opentdk.gui.application.BaseApplication</code> that acts like a common JavaFX main class and takes some initial steps. 
2. The <code>SampleController</code> class steers the behaviour of the GUI. It gets initialized in the <code>showRootLayout</code> method and is connected to a FXML file.
3. The <code>Application.launch</code> method starts the JavaFX application thread that calls <code>Application.init</code> and then <code>Application.start</code> that calls <code>showRootLayout</code>.
4. The <code>init</code> method gets overwritten to set some main properties. This is optional, but there is one exception named in (5).
5. The <code>ResourceBundle</code> object gets used to initialize or point to a <code>.properties</code> file on the classpath that contains key value pairs for internationalization. In this case it is a file named <code>Bundle_en.properties</code> (concatenation of name and language). If it should be used, it has to be initialized in the <code>init</code> method.
6. These are three sample settings. The usage of a <code>.css</code> file to change the look of the application and the width and height.
7. This is the part where the window gets initialized and started. The <code>BaseApplication.showStage</code> method loads the FXML file <code>Sample.fxml</code> with a title from the resource bundle.

Remaining questions: 

- How does this FXML file look and how is it created?
- And how does the controller class look like?

So let's complete the JavaFX project and go to  

- [createFxmlFile](createFxmlFile.md)
- [createControllerClass](createControllerClass.md) 































