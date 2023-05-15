FROM amazoncorretto:17
MAINTAINER agustina
COPY target/Agustina-0.0.1-SNAPSHOT.jar Agustina-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/Agustina-0.0.1-SNAPSHOT.jar"]