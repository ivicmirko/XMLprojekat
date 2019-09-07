FROM anapsix/alpine-java
MAINTAINER Stefan Colic <stefan.colic4@gmail.com>
ADD target/containerized-admin2-0.0.1-SNAPSHOT.jar containerized-admin.jar
ENTRYPOINT ["java", "-jar", "/containerized-admin.jar"]
EXPOSE 2222
