FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
VOLUME /tmp
EXPOSE 8080
COPY pom.xml .
COPY src ./src
RUN apk add --no-cache maven
RUN mvn package -DskipTests
ENTRYPOINT ["java", "-jar", "/app/target/BalancePro-0.0.1-SNAPSHOT.jar"]