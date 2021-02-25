FROM openjdk:11.0.10-oraclelinux7
COPY . /usr/src
WORKDIR /usr/src
RUN ./mvnw clean package -pl :image-service -am
ENTRYPOINT ["java", "-jar", "/usr/src/image-service/target/image-service.jar"]
