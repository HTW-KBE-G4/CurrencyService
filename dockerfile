#Step 1: build jar...
FROM maven:3.8.1-openjdk-17 as MAVEN_ENV

WORKDIR /tmp/app

COPY pom.xml .

COPY src ./src/

#package the jar
RUN mvn package -DskipTests=true

#Step 2: copy jar to jdk image
FROM openjdk:17

COPY --from=MAVEN_ENV /tmp/app/target/Currency-Service-0.0.1-SNAPSHOT.jar /usr/local/app/app.jar

WORKDIR /usr/local/app/

EXPOSE 4003

ENTRYPOINT ["java", "-jar", "app.jar"]

