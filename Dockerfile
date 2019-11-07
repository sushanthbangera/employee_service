FROM maven:3.5-jdk-8 AS build
COPY src /usr/quiz-employee-service/src
COPY pom.xml /usr/quiz-employee-service
RUN mvn -f /usr/quiz-employee-service/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb:27017/glarimy", "-jar","/usr/quiz-employee-service/target/quiz-employee-service-1.0.0.jar"]