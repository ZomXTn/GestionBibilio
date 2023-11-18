FROM maven:3.9.5-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests clean package 

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/GestionBibiliotheque-0.0.1-SNAPSHOT.jar app.jar

CMD [ "java", "-jar" , "app.jar" ]

