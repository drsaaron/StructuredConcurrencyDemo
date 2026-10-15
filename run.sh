#! /bin/sh

java -Dspring.config.name=application,${ENVIRONMENT:-test} --enable-preview -jar target/$(getPomAttribute.sh artifactId)-$(getPomAttribute.sh version).jar
