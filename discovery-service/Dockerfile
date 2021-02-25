FROM openjdk:11.0.10-oraclelinux7
COPY . /usr/src
WORKDIR /usr/src
RUN ./mvnw clean package -pl :discovery-service -am
ENTRYPOINT ["java", "-jar", "/usr/src/discovery-service/target/discovery-service.jar"]
