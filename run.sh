#! /bin/sh

java -Dspring.config.name=application,${ENVIRONMENT:-test} --enable-preview -jar target/*jar 
