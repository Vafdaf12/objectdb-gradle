# ObjectDB+Gradle Template
This is a starter project for working with ObjectDB and Gradle. The code is mainly adapted from the [ObjectDB Maven Example](https://www.objectdb.com/tutorial/jpa/start/maven) to work with Gradle, with some slight improvements.

## Connecting to ObjectDB
Connecting to an ObjectDB instance (whether local or remote), will create a database file where all your objects are stored

### Local
The following example creates a database file `db/points.db` where all your persisted objects are stored (relative to the current working directory):

```java
var emf = Persistence.createEntityManagerFactory("objectdb:db/points.odb");
```

### Remote (using ObjectDB server)
The default credentials for an ObjectDB server is `admin` for both username and password.

```java
var properties = new HashMap<String, String>();
properties.put("javax.persistence.jdbc.user", "admin");
properties.put("javax.persistence.jdbc.password", "admin");
var emf = Persistence.createEntityManagerFactory("objectdb://localhost:6136/points.odb", properties);
```
To set up an ObjectDB server, refer to https://github.com/S3BzA/COS326-Dockerised-Databases

## Running
To run the application, run
```sh
.\gradlew run    # Windows (Powershell)
gradlew run      # Windows (Command Prompt)
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
