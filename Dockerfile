FROM azul/zulu-openjdk:17-latest

RUN mvn clean install
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
