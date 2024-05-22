

# OpenJDK 17과 Gradle 지정
FROM gradle:7.6.1-jdk17 AS build

WORKDIR /app

COPY build.gradle setting.gradle ./

RUN gradle dependencies --no-daemon

COPY . /app

RUN  gradle clean build --no-daemon

FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/mingle.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]