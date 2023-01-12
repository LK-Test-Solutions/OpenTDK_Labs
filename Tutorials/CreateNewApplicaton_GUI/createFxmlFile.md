# Build FXML files

**Prerequisite: Installed [SceneBuilder](https://gluonhq.com/products/scene-builder/) application**

Let's have a look at this tool. It is designed to create FXML files without typing the XML structure but using GUI 
elements. This saves a lot of time.

The following areas are the most important ones:

1. List of all available GUI elements. Use the search function to get the required one more quickly.
2. Object tree that shows all already used elements
3. Workspace to drag and drop the elements into
4. Area to edit the elements settings with the sections *Properties*, *Layout* and *Code*. More details in the example below.

![](img/SceneBuilder.png)

Important to mention is the controller section below of area 2. There you have the possibility to type in the classpath of the
belonging controller class. In case that the FXML file and the class are in the same project or package (which is highly recommended),
SceneBuilder proposes the available classes.

### Example for this tutorial: Edit a table with persons

Drag a new ``BorderPane`` into the workspace.

![](img/SceneBuilder-newBorderPane.png)

Drag new ``GridPane`` in the top area.
