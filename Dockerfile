FROM amazoncorretto:21-alpine

ARG JAR_FILE=build/libs/timer-1.0.0.jar
WORKDIR /home/app
COPY ${JAR_FILE} /home/app/app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/home/app/app.jar"]