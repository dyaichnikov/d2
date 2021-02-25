FROM openjdk:11.0.10-oraclelinux7
COPY . /usr/src
WORKDIR /usr/src
RUN ./mvnw clean package -pl :user-service -am
ENTRYPOINT ["java", "-jar", "/usr/src/user-service/target/user-service.jar"]
