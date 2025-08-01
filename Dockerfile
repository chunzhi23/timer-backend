FROM amazoncorretto:21-alpine

RUN apk add --no-cache tzdata \
  && cp /usr/share/zoneinfo/Asia/Seoul /etc/localtime \
  && echo "Asia/Seoul" > /etc/timezone

ENV TZ=Asia/Seoul
ENV LANG=ko_KR.UTF-8
ENV LANGUAGE=ko_KR:ko

ARG JAR_FILE=build/libs/timer-1.0.0.jar
WORKDIR /home/app
COPY ${JAR_FILE} /home/app/app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/home/app/app.jar"]