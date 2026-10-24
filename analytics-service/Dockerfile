FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app
COPY --from=builder /app/target/*.jar ./analytics-service.jar
EXPOSE 4002
ENTRYPOINT ["java", "-jar", "analytics-service.jar"]