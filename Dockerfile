FROM openjdk:17-jdk-slim AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/frete-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]