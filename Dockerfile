FROM openjdk:11
WORKDIR /app
COPY ./target/gestac-0.0.1-SNAPSHOT.jar ./gestac.jar
CMD [ "java", "-jar",  "gestac.jar"]