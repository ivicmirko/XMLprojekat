FROM anapsix/alpine-java
MAINTAINER Stefan Colic <stefan.colic4@gmail.com>
ADD target/containerized-agent-0.0.1-SNAPSHOT.jar containerized-agent.jar
ENTRYPOINT ["java", "-jar", "/containerized-agent.jar"]
EXPOSE 2226
