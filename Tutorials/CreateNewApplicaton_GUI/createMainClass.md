# How to create a JavaFX main class with OpenTDK

The documentation of the 
[BaseApplication](https://github.com/LK-Test-Solutions/OpenTDK_Labs/blob/main/Documentation/Concepts/BaseApplication_GUI.md)
contains the basic content of a main class that uses the <code>org.opentdk.gui.application</code> package.

Here is a more detailed version that we will walk through now.

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
	public void init() throws Exception {
		super.setResourceBundle(ResourceBundle.getBundle("application.test.Bundle", new Locale("en")));
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
```

1. The class inherits from <code>org.opentdk.gui.application.BaseApplication</code> that acts like a common JavaFX main class and takes some initial steps. 
2. The <code>SampleController</code> class steers the behaviour of the GUI. It gets initialized in the <code>initRootLayout</code> method and is connected to a FXML file.
3. The <code>Application.launch()</code> method starts the JavaFX application thread that calls <code>Application.init()</code> and then <code>Application.start()</code> that calls <code>showRootLayout()</code>.
4. 


To complete the JavaFX project see 
- [createControllerClass](createControllerClass.md) 
- [createFxmlFile](createFxmlFile.md)






























