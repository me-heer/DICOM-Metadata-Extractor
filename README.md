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

I have used the PixelMed library: http://www.pixelmed.com/dicomtoolkit.html
