# Graphical user interface

The <code>gui.application</code> module was developed to easily create JavaFX GUI applications without dealing with the 
common JavaFX barriers.

The main class <code>BaseApplication</code> is a derivation of the <code>javafx.Application</code> class. The main class
of the own project inherits from the <code>BaseApplication</code> class instead of directly inheriting from 
<code>Application</code> (which is common for JavaFX main classes). This helps to get started more quickly. 

```
public class MainApp extends BaseApplication { 
	
	private SampleController controller; // Controller class for the main layout

	public static void main(String[] args) {
	    launch(); // Calls Application.start() that calls initRootLayout() below
	}

	@Override
	protected void showRootLayout() {
            try {
                // Loads the main window and connects the controller class with the .fxml file              
                controller = (SampleController) super.showStage("Sample.fxml", "Title", super.getPrimaryStage());
                           
            } catch (IOException e) {
                MLogger.getInstance().log(Level.SEVERE, e);		
            } 
            Platform.exit(); // Terminates the JavaFX application thread
	}
}
```

For the first startup the controller class can stay empty. The FXML file has to contain at least a root element. In 
this case it is located in the same directory as the controller class, because only the name <code>Sample.fxml</code>
gets passed.

A detailed tutorial can be found in the 
[Tutorials](https://github.com/LK-Test-Solutions/OpenTDK_Labs/tree/main/Tutorials) section. 

