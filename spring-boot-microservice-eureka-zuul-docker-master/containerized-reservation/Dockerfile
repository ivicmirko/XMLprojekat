FROM anapsix/alpine-java
MAINTAINER Stefan Colic <stefan.colic4@gmail.com>
ADD target/containerized-reservation-0.0.1-SNAPSHOT.jar containerized-reservation.jar
ENTRYPOINT ["java", "-jar", "/containerized-reservation.jar"]
EXPOSE 2222