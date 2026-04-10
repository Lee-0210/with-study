FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/with-boot-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]