#!/bin/bash
javac -d ./classes -sourcepath ./src src/vttp/batch5/sdf/task02/Main.java && \
	java -cp classes vttp.batch5.sdf.task02.Main TTT/figure1.txt
