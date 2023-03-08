FROM openjdk:11

COPY target/*.jar app/app.jar

ENV SERVER_PORT=8080

CMD ["java","-jar","app/app.jar"]

