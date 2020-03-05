## Code Challenge
To run the project from terminal:
- Clone the repository, open terminal in the root directory of the project and use the following commands:
- Install the dependencies:
``` mvn install ```
- Compile the project:
``` mvn compile ```
- Run:
```
java -classpath /path/to/project/target/classes:/path/to/project/lib/pixelmed.jar org.camicroscope.CodeChallenge
```
e.g.:
``` 
java -classpath /home/mihir/Desktop/DICOM/target/classes:/home/mihir/Desktop/DICOM/lib/pixelmed.jar org.camicroscope.CodeChallege
```
- I have used the PixelMed library: http://www.pixelmed.com/dicomtoolkit.html
- I have commented out the code which stores the data in a local database and instead, printed the metadata to the terminal.
- The sample file is at the root of the directory: 0002.DCM
- References for the library usage: https://saravanansubramanian.com/extractdicomimagedata/
 
The source files are:
- https://github.com/mformihir/DICOM/blob/master/src/main/java/org/camicroscope/CodeChallenge.java
- https://github.com/mformihir/DICOM/blob/master/src/main/java/org/camicroscope/DICOM.java
