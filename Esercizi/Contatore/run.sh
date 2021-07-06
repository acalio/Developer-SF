#!/usr/bin/sh
javac -d . src/*.java
jar vcfm app.jar MANIFEST.MF  *.class > /dev/null
java -jar app.jar
rm *.class
