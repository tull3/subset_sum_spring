# Getting Started

### Building and Running on Linux/Unix

- Make sure the `CATALINA_HOME` and `JAVA_HOME` environmental variables are set appropriately for your system.
- Make sure Tomcat's `catalina.sh` file is in your system's `PATH`.  The preferred method is to create a symlink in a folder already in the `PATH`.
- Run `./deploy.sh` from a shell in the project's root directory.
- Go to [http://localhost:8080/demo-0.0.1-SNAPSHOT](http://localhost:8080/demo-0.0.1-SNAPSHOT) in a browser.

### Building and Running on Windows

- Make sure the `CATALINA_HOME` and `JAVA_HOME` environmental variables are set appropriately for your system.
- Make sure Tomcat's `catalina.sh` file is in your system's `PATH`.
- Run `mvn clean package` from a shell in the project's root directory.
- Move `target/demo-0.0.1-SNAPSHOT.war` to the `CATALINA_HOME/webapps/` directory.
- Run `catalina.sh start`.
- Go to [http://localhost:8080/demo-0.0.1-SNAPSHOT](http://localhost:8080/demo-0.0.1-SNAPSHOT) in a browser.

In either case, use `catalina.sh stop` to shut down Tomcat.