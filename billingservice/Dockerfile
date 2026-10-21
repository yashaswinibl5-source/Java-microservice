FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app
COPY --from=builder /app/target/*.jar ./billingservice.jar
EXPOSE 4001
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "billingservice.jar"]