# OpenTDK Helper (Utility) Classes
The OpenTDK Utility classes provide a collection of methods to deal with various date, I/O and List related activities. In addition a number of methods for mathematical functions e.g. to calculate the standard deviation are provided to simplify development.

# DateUtil

Class | Description
------|------------
`DateUtil` | Class with static utility methods to work with date, time and time stamp formats using the java.time package.

<BR>
<BR>


# I/O - FileUtil, XFileWriter, XMLEditor

The classes provided in package **IO** facilitate the reading from and writing to files. Especially class `FileUtil` supports any use cases related to filesystems.

Class | Description
------|------------
`FileUtil` | Class with static methods to perform several I/O operations like reading files, creating files or checking files.
`XFileWriter` | This class uses FileWriter for write operations on ASCII files with additional functionality.
`XMLEditor` | This class is used for read and write access to data which is stored in XML format.

<BR>
<BR>


### Examples:

1. Check if a file exists; if it does not exist create it
``` java
// The return value can be used in other operations
// In this example the folder structure is not created if it does not exist already
 boolean exists = FileUtil.checkDir(FILE_PATH_AND_NAME, false);
```

2. Create a file. Optionally the folder structure can be created as well

```java
// Create folder structure
boolean success = FileUtil.createFile(FILE_PATH_AND_NAME, true);
```

3. Rename file

```java
 FileUtil.renameFile(FILE_PATH_AND_NAME, RENAME_PATH_AND_NAME);
```

4. Copy file

```java
FileUtil.copyFile(FILE_PATH_AND_NAME, COPY_PATH_AND_NAME);
```

5. Remove (delete) file and/or folder

```java
FileUtil.deleteFileOrFolder(FILE_PATH_OR_FULL_NAME);
```

Comments: 

* The parameters for files are *fullnames* means consist of the folder *and* the filename


//TODO - add link to error handling chapter
* Most methods throw exceptions/errors which must be handled by the caller. Please refer to chapter Error Handling as well. 

//TODO - add link to error handling chapter

# ListUtil

Class | Description
------|------------
`ListUtil` | Helper class for lists which contains statis methods only which can be called without creating an instance of the class.

<BR>
<BR>

# MathUtil


Class | Description
------|------------
`MathUtil` | Class with useful mathematical functions. They can be called in a static way, similar to the Java Math library.