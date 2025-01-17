# Added java.util.Date field in students.csv

Use of customized fieldsetmapper in [jobConfiguration](https://github.com/panik5467/spring-batch-examples/blob/master/reading-data/csv-file/src/main/java/net/petrikainulainen/spring/batch/SpringBatchExampleJobConfig.java)

With java.time.LocalDate:

	String date = pFielSet.readString("dateTest");
	DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMyyyy");
	student.setDateTest(LocalDate.parse(date, df));

# Test With Spring Course

If you are struggling to write good automated tests for Spring web applications, you are not alone! [I have launched a video course](https://www.testwithspring.com/?utm_source=github&utm_medium=social&utm_content=spring-batch&utm_campaign=test-with-spring-course-presales) that describes how you can write automated tests which embrace change and help you to save your time (and nerves).

# Spring Batch Tutorial

This repository contains the example ammplications of my Spring Batch tutorial. This repository contains two examples that are described in the following:

* The _spring_ directory contains an example application that uses Spring Framework.
* The _spring-boot_ directory contains an example application that uses Spring Boot.

