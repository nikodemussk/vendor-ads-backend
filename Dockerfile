FROM azul/zulu-openjdk:17-latest

COPY jarFile/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
