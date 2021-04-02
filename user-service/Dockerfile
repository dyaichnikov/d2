FROM maven:3.6.1 AS build
COPY . /usr/src
WORKDIR /usr/src
RUN mvn clean package -pl :user-service -am

FROM openjdk:11.0.10-oraclelinux7
COPY --from=build /usr/src/user-service/target/user-service.jar /usr/app/user-service.jar
ENTRYPOINT ["java", "-jar", "/usr/app/user-service.jar"]
