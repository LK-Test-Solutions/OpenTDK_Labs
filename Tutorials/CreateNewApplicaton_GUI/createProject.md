# How to create involved classes and files

First of all, the Maven project automatically has its <code>pom.xml</code> file. For this tutorial it should look 
like this:

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>JavaFXApplication</groupId>
	<artifactId>JavaFXApplication</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<resources>
			<resource>
				<directory>src</directory>
				<excludes>
					<exclude>**/*.java</exclude>
				</excludes>
			</resource>
		</resources>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<release>19</release>
				</configuration>
			</plugin>
		</plugins>
	</build>
	<dependencies>
		<dependency>
			<groupId>org.openjfx</groupId>
			<artifactId>javafx-base</artifactId>
			<version>19</version>
		</dependency>
		<dependency>
			<groupId>org.openjfx</groupId>
			<artifactId>javafx-controls</artifactId>
			<version>19</version>
		</dependency>
		<dependency>
			<groupId>org.openjfx</groupId>
			<artifactId>javafx-fxml</artifactId>
			<version>19</version>
		</dependency>
		<dependency>
			<groupId>org.openjfx</groupId>
			<artifactId>javafx-swing</artifactId>
			<version>19</version>
		</dependency>
		<dependency>
			<groupId>org.json</groupId>
			<artifactId>json</artifactId>
			<version>20220320</version>
		</dependency>
		<dependency>
			<groupId>org.opentdk</groupId>
			<artifactId>opentdk-api</artifactId>
			<version>1.6.0</version>
		</dependency>
		<dependency>
			<groupId>org.opentdk</groupId>
			<artifactId>opentdk-gui</artifactId>
			<version>1.5.9</version>
		</dependency>
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.12.0</version>
		</dependency>
		<dependency>
			<groupId>commons-codec</groupId>
			<artifactId>commons-codec</artifactId>
			<version>1.15</version>
		</dependency>
		<dependency>
			<groupId>org.yaml</groupId>
			<artifactId>snakeyaml</artifactId>
			<version>1.33</version>
		</dependency>
	</dependencies>
</project>
```

It has the required coordinates at the top, all dependencies and the used Java version.

And the project/module has its module-info file, that has to look like this:

```
module mainappgroup {
    opens application.test to javafx.fxml, javafx.graphics, javafx.base, opentdk.gui;
    
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;	
    requires javafx.swing;
    
    requires opentdk.gui;
}
```

The project need to allow access to the JavaFX modules and the <code>opentdk.gui</code> module. Unfortunately <code>
opens</code> is necessary and using <code>exports</code> is not sufficient.
Afterwards all required modules are listed.

All other files in the main package <code>application.test</code> can be created without any content.

- application.css
- Bundle_en.properties
- MainApp.java
- Person.java
- Sample.fxml
- SampleController.java

The files get brought to live in the following pages.

- [createMainClass](createMainClass.md)
- [createFxmlFile](createFxmlFile.md)
- [createControllerClass](createControllerClass.md)
