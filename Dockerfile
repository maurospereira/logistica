FROM openjdk
WORKDIR /app
COPY target/logistica-0.0.1-SNAPSHOT.jar /app/logistica.jar
ENTRYPOINT ["java","-jar","logistica.jar"]

