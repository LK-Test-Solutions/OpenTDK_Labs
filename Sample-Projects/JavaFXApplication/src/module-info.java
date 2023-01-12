module mainappgroup {
	opens application.test to javafx.fxml, javafx.graphics, javafx.base, opentdk.gui;
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;	
	requires javafx.swing;
	
	requires opentdk.gui;
}