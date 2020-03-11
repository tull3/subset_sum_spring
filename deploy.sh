#!/bin/sh

mvn clean package

cp target/demo-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/

catalina.sh start