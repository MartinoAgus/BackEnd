FROM amazoncorretto:17
MAINTAINER agustina
COPY target/agustina-portfolio-0.0.1-SNAPSHOT.jar agustina-portfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/agustina-portfolio-0.0.1-SNAPSHOT.jar"]