# ObjectDB+Gradle Template
This is a starter project for working with ObjectDB and Gradle. The code is mainly adapted from the [ObjectDB Maven Example](https://www.objectdb.com/tutorial/jpa/start/maven) to work with Gradle, with some slight improvements.

## Running
To run the application, run
```sh
gradlew run      # Windows
./gradlew run    # Linux/Mac
```

Unfortunately a distributable JAR is not yet supported, as it seems to be a very involved process.

## Project Structure
The `src` directory is where all the application code goes:
```
src/
├─ main/        # The main application code
│  ├─ java/         # All your Java source files
│  ├─ resources/    # Any non-Java files you might need for the project
├─ test/        # Testing code
│  ├─ java/         # All the Java files used for testing
│  ├─ resources/    # Any non-Java files needed for testing
```
