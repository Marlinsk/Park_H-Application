FROM maven:3-openjdk-16 AS builder

WORKDIR /park-h-rest-api/app/src/

COPY src ./
COPY pom.xml ../

RUN mvn -f /park-h-rest-api/app/pom.xml clean package

FROM openjdk:16.0.1

WORKDIR /park-h-rest-api/lib/

COPY --from=builder /park-h-rest-api/app/target/Park-H-REST-Api-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/park-h-rest-api/lib/app.jar"]