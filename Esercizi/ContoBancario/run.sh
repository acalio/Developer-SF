#!/usr/bin/sh
jar vcfm app.jar MANIFEST.MF  *.class > /dev/null
java -jar app.jar
rm *.class
