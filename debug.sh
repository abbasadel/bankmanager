#!/bin/sh
mvn clean install
mvnDebug  jetty:run -pl ./Web
#mvn jetty:run -pl ./Web

