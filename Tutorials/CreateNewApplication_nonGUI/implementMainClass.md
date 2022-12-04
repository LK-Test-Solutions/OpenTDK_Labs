# Introduction
Following the implementation steps below, you will be able to create a main class which can be launched with: 
* command line arguments, 
* settings that are defined in XML files,
* predefined default settings,
* or a combination of all above

This allows to initialize the application at startup with all relevant data, by just calling two methods within the constructor of the main class. All arguments and settings will automatically be assigned to runtime storage objects and their values can be accessed at runtime by simple getter and setter methods by all classes of the application.
For more information about this concept see ...

# Prerequisites
* A dispatcher class needs to exist with declarations of type DispatchComponent for all properties that are useful to define the runtime configuration of the application.
* A dispatcher class needs to exist with declarations of type DispatchComponent for all settings that can be stored in a settings file. These settings stay available also when the application is not running.

# Implementation steps
1. Create a new class that extends the class org.opentdk.api.application.BaseApplication
2. Implement a main method which creates a new instance of the application class
3. Implement a constructor with an args argument
4. Call the methods `parseArgs` and `initRuntimeSettings` to initialize the settings, used at runtime of the application

# Code template
```
    import org.opentdk.api.application.BaseApplication;
    public class Application extends BaseApplication {

	public static void main(String[] args) throws Exception {
		new Application(args);
	}
	
	public Application(String[] args) throws Exception {
		// reads all arguments from the args String Array and assigns the values to 
		// their related DispatchComponent instance of the ERuntimeProperties class
		parseArgs(ERuntimeProperties.class, args);
		// all empty DispatchComponent instances of ERuntimeSettings will retrieve their
		// initial values from an assigned settings file, or from the default values, 
		// defined within the EAppSettings class
		initRuntimeProperties(ERuntimeProperties.class, EAppSettings.class);
	}
    }
```

# Usage samples


