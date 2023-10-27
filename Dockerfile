FROM eclipse-temurin:17-jdk-jammy

WORKDIR /usr/local/var/postgres

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

CMD ["./mvnw", "spring-boot:run"]