FROM eclipse-temurin:18.0.2.1_1-jdk-focal as builder
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./mvnw clean install -DskipTests

FROM builder
COPY --from=builder /app/source/target/mail-service-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "/app/app.jar"]