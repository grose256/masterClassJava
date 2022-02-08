#!/bin/bash
echo "Please enter name of .java source "
read java_program

# First, compile the Java programs into Java classes
javac ${java_program}.java
  
# Now pass the arguments to the Java classes
java ${java_program}


