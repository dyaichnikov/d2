FROM maven:3.6.1
COPY . /usr/src
WORKDIR /usr/src
RUN mvn clean package -pl :user-service -am

FROM openjdk:11.0.10-oraclelinux7
COPY --from=build /usr/src/image-service/target/image-service.jar /usr/app/image-service.jar
ENTRYPOINT ["java", "-jar", "/usr/app/image-service.jar"]